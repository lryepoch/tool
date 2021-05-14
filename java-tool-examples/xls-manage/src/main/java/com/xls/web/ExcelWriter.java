package com.xls.web;

import com.xls.bean.Area;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author lryepoch
 * @date 2020/7/3 15:54
 * @description TODO
 */
public class ExcelWriter {

    private static List<String> CELL_HEADS;//列头

    static {
        //类装载时就载入指定好的列头信息，如有需要，可以考虑做成动态生成的列头
        CELL_HEADS = new ArrayList<String>();
        CELL_HEADS.add("编码");
        CELL_HEADS.add("省份");
        CELL_HEADS.add("城市");
        CELL_HEADS.add("区域");
        CELL_HEADS.add("邮政编码");
    }

    /**
     * 生成excel并写入数据信息
     */
    public static Workbook exportData(List<Area> dataList) {
        //生成xlsx的Excel
        Workbook workbook = new SXSSFWorkbook();

        // 如需生成xls的Excel，请使用下面的工作簿对象，注意后续输出时文件后缀名也需更改为xls
        //Workbook workbook = new HSSFWorkbook();

        //生成sheet表，写入第一行的列头
        Sheet sheet = buildDataSheet(workbook);

        //构建每行的数据内容（第0行已经作为列头）
        int rowNum = 1;
        for (Iterator<Area> it = dataList.iterator(); it.hasNext(); ) {
            Area data = it.next();
            if (data == null) {
                continue;
            }
            //输出行数据
            Row row = sheet.createRow(rowNum++);
            convertDataToRow(data, row);
        }
        return workbook;
    }

    /**
     * 生成sheet表，并写入第一行数据（列头）
     *
     * @param workbook 工作簿对象
     * @return 已经写入列头的Sheet
     */
    public static Sheet buildDataSheet(Workbook workbook) {
        Sheet sheet = workbook.createSheet();
        //设置列头宽度
        for (int i = 0; i < CELL_HEADS.size(); i++) {
            sheet.setColumnWidth(i, 4000);
        }
        //设置默认行高
        sheet.setDefaultRowHeight((short) 400);
        //构建头单元格样式
        CellStyle cellStyle = buildHeadCellStyle(sheet.getWorkbook());
        //写入第一行各列的数据
        Row head = sheet.createRow(0);
        for (int i = 0; i < CELL_HEADS.size(); i++) {
            Cell cell = head.createCell(i);
            cell.setCellValue(CELL_HEADS.get(i));
            cell.setCellStyle(cellStyle);
        }
        return sheet;
    }

    /**
     * 设置第一列头的样式
     */
    private static CellStyle buildHeadCellStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        //对齐方式设置
        style.setAlignment(HorizontalAlignment.CENTER);
        //边框颜色和宽度设置
        style.setBorderBottom(BorderStyle.THIN);
        //下边框
        style.setBottomBorderColor(IndexedColors.BLUE.getIndex());
        //左边框
        style.setLeftBorderColor(IndexedColors.BLUE.getIndex());
        //右边框
        style.setRightBorderColor(IndexedColors.BLUE.getIndex());
        //上边框
        style.setTopBorderColor(IndexedColors.BLUE.getIndex());
        //背景颜色
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //粗体字
        Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        return style;
    }

    /**
     * 将数据转换成行
     */
    public static void convertDataToRow(Area area, Row row) {
        int cellNum = 0;
        Cell cell;
        //地区编码
        cell = row.createCell(cellNum++);
        cell.setCellValue(area.getAreaNum());
        //省份
        cell = row.createCell(cellNum++);
        cell.setCellValue(area.getProvince());
        //城市
        cell = row.createCell(cellNum++);
        cell.setCellValue(area.getCity() == null ? "" : area.getCity());
        //区域
        cell = row.createCell(cellNum++);
        cell.setCellValue(area.getDistrict());
        //邮政编码
        cell = row.createCell(cellNum++);
        cell.setCellValue(area.getPostcode());
    }

}
