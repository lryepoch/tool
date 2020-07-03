package cn.com.xls.web;

import cn.com.xls.bean.Area;
import org.apache.poi.hssf.usermodel.HSSFSheet;
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
import java.util.Iterator;
import java.util.List;

/**
 * @author lryepoch
 * @date 2020/7/3 14:59
 * @description TODO
 */
public class Import_xls {


    /**
     * @description 导入excel【xls格式】数据到控制台
     * @author lryepoch
     * @date 2020/7/3 10:37
     */
    public static List<Area> importXLS(String path) {
        List<Area> list = new ArrayList<Area>();
        try {
            File file = new File(path);
            //1.获取文件输入流
            InputStream inputStream = new FileInputStream(file);
            //2.获取Excel工作簿对象
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            //3.得到Excel工作表对象
            HSSFSheet sheetAt = workbook.getSheetAt(0);
            //4.循环读取表格数据
            for (Row row : sheetAt) {
                //首行（即表头）不读取,直接跳过首行
                if (row.getRowNum() == 0) {
                    continue;
                }
                //读取当前行中单元格数据，索引从0开始
                Integer areaNum = Integer.valueOf(row.getCell(0).getStringCellValue());
                String province = row.getCell(1).getStringCellValue();
                String city = row.getCell(2).getStringCellValue();
                String district = row.getCell(3).getStringCellValue();
                Integer postcode = Integer.valueOf(row.getCell(4).getStringCellValue());

                Area area = new Area();
                area.setAreaNum(areaNum);
                area.setProvince(province);
                area.setCity(city);
                area.setDistrict(district);
                area.setPostcode(postcode);
                list.add(area);
            }
            //5.关闭流
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /*************************************/

    /**
     * @return
     * @description 导入excel数据到控制台
     * @author lryepoch
     * @date 2020/7/3 10:38
     */
    public static List<Area> insert(String path) throws IOException {
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
            Sheet sheet = workbook.getSheetAt(0);
            //校验sheet是否合法
            if (sheet == null) {
                continue;
            }

            //获取第一行数据
            int firstRowNum = sheet.getFirstRowNum();
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


    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\260408\\Desktop\\2.xls";

        List<Area> list0 = importXLS(path);

        List<Area> list = insert(path);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
