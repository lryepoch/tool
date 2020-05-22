package cn.com.xls.web;

import cn.com.xls.bean.Area;
import org.apache.poi.hssf.usermodel.HSSFRow;
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
 * @date 2019-11-30 2019/11/30
 * @description
 */
public class XlsController {

    public List<Area> importXLS() {
        List<Area> list = new ArrayList<Area>();

        try {
            File file = new File("C:\\Users\\260408\\Desktop\\区域数据.xls");
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
                String areaNum = row.getCell(0).getStringCellValue();
                String province = row.getCell(1).getStringCellValue();
                String city = row.getCell(2).getStringCellValue();
                String district = row.getCell(3).getStringCellValue();
                String postcode = row.getCell(4).getStringCellValue();

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

    public void exportXLS() throws IOException {
        //声明一个字符串数组
        String[] strings = {"广东", "珠海", "香洲", "A525239"};
        //1.在内存中创建一个excel文件
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        //2.创建工作簿
        HSSFSheet sheet = hssfWorkbook.createSheet();
        //3.创建标题行
        HSSFRow titlerRow = sheet.createRow(0);
        titlerRow.createCell(0).setCellValue("省");
        titlerRow.createCell(1).setCellValue("市");
        titlerRow.createCell(2).setCellValue("区");
        titlerRow.createCell(3).setCellValue("邮编");

        for (String area : strings) {
            //获取最后一行的行号
            int lastRowNum = sheet.getLastRowNum();
            HSSFRow dataRow = sheet.createRow(lastRowNum + 1);
            dataRow.createCell(0).setCellValue(area);
            dataRow.createCell(1).setCellValue(area);
            dataRow.createCell(2).setCellValue(area);
            dataRow.createCell(3).setCellValue(area);
        }
/*        //5.创建文件名
        String fileName = "区域数据统计.xls";
        //6.获取输出流对象
        HttpServletResponse response = ServletActionContext.getResponse();
        ServletOutputStream outputStream = response.getOutputStream();
        //7.获取mimeType
        ServletContext servletContext = ServletActionContext.getServletContext();
        String mimeType = servletContext.getMimeType(fileName);
        //8.获取浏览器信息，对文件名进行重新编码
        HttpServletRequest request = ServletActionContext.getRequest();
        fileName = FileUtils.filenameEncoding(fileName, request);
        //9.设置信息头
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition","attachment;filename="+fileName);
        //10.写出文件，关闭流
        hssfWorkbook.write(outputStream);
        hssfWorkbook.close();*/
    }

    public static void main(String[] args) {
        XlsController xls = new XlsController();
        List<Area> list = xls.importXLS();
        //利用Iterator输出到控制台
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
        System.out.println(list);

    }
}