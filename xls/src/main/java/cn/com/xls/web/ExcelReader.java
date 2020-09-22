package cn.com.xls.web;

import cn.com.xls.bean.Area;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lryepoch
 * @date 2020/7/6 14:44
 * @description TODO
 */
public class ExcelReader {

    /**
     * @return
     * @description 导入excel数据到控制台
     * @author lryepoch
     * @date 2020/7/3 10:38
     */
    public static List<Area> parse(String path) throws IOException {
        List<Area> list = new ArrayList<Area>();

        File file = new File(path);
        InputStream inputStream = new FileInputStream(file);

        //获取工作簿
        Workbook workbook = null;

        String fileType = path.substring(path.lastIndexOf(".") + 1);
        if (fileType.equals("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        }
        if (fileType.equals("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        }

        //获取工作表
        for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
            Sheet sheet = workbook.getSheetAt(sheetNum);
            //校验sheet是否合法
            if (sheet == null) {
                continue;
            }

            //第一行
            int firstRowNum = sheet.getFirstRowNum();
            //获取第一行数据
            Row firstRow = sheet.getRow(firstRowNum);
            if (firstRow == null) {
                System.out.println("解析失败，第一行没有读到任何数据");
            }

            int rowStart = firstRowNum + 1;
            int rowEnd = sheet.getPhysicalNumberOfRows();
            for (int rowNum = rowStart; rowStart < rowEnd; rowNum++) {
                Row row = sheet.getRow(rowNum);
                if (row == null) {
                    break;
                }

                Area area = convertRowToData(row);
                if (area == null) {
                    System.out.println("第" + row.getRowNum() + "行数据不合法，已忽略！");
                    continue;
                }
                list.add(area);
            }
        }
        return list;
    }

    /**
     * 提取每一行中需要的数据，构造成为一个结果数据对象
     * <p>
     * 当该行中有单元格的数据为空或不合法时，忽略该行的数据
     *
     * @param row 行数据
     * @return 解析后的行数据对象，行数据错误时返回null
     */
    public static Area convertRowToData(Row row) {
        Area area = new Area();

        //单元格
        Cell cell;
        int cellNum = 0;
        cell = row.getCell(cellNum++);
        String areaNumStr = convertCellValueToString(cell);
        area.setAreaNum(Integer.valueOf(areaNumStr));

        cell = row.getCell(cellNum++);
        String province = convertCellValueToString(cell);
        area.setProvince(province);

        cell = row.getCell(cellNum++);
        String city = convertCellValueToString(cell);
        area.setCity(city);

        cell = row.getCell(cellNum++);
        String district = convertCellValueToString(cell);
        area.setDistrict(district);

        cell = row.getCell(cellNum++);
        String postcodeStr = convertCellValueToString(cell);
        area.setPostcode(Integer.valueOf(postcodeStr));

        return area;
    }

    /**
     * 将单元格内容转换为字符串
     */
    public static String convertCellValueToString(Cell cell) {
        if (cell == null) {
            return null;
        }
        String returnValue = null;
        switch (cell.getCellType()) {
            //数字
            case NUMERIC:
                Double doubleValue = cell.getNumericCellValue();
                DecimalFormat df = new DecimalFormat("0");
                returnValue = df.format(doubleValue);
                break;
            //字符串
            case STRING:
                returnValue = cell.getStringCellValue();
                break;
            //布尔
            case BOOLEAN:
                Boolean booleanValue = cell.getBooleanCellValue();
                returnValue = booleanValue.toString();
                break;
            //空值
            case BLANK:
                break;
            //公式
            case FORMULA:
                returnValue = cell.getCellFormula();
                break;
            case ERROR:
                break;
            default:
                break;
        }
        return returnValue;
    }

}
