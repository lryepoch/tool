package com.xls.web;

import com.xls.bean.Area;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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



    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\260408\\Desktop\\2.xls";

//        List<Area> list0 = importXLS(path);

        List<Area> list = ExcelReader.parse(path);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
