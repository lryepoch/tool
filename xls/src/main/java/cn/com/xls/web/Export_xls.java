package cn.com.xls.web;

import cn.com.xls.bean.Area;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author lryepoch
 * @date 2020/7/3 14:59
 * @description TODO
 */
public class Export_xls {

    /**
     * @description 生成数据到excel表
     * @author lryepoch
     * @date 2020/7/3 10:38
     */
    public static void exportXLS() throws IOException {
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

        /*
        //5.创建文件名
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
        hssfWorkbook.close();
        */

    }



    public static void main(String[] args) throws IOException {
//        exportXLS();

        List<Area> areas = new ArrayList<Area>();
        Area area1 = new Area();
        area1.setAreaNum(2);
        area1.setProvince("江西");
        area1.setCity("赣州");
        area1.setDistrict("xx");
        area1.setPostcode(70898) ;

        Area area2 = new Area();
        area2.setAreaNum(3);
        area2.setProvince("北京");
        area2.setCity("北京");
        area2.setDistrict("oo");
        area2.setPostcode(7098) ;

        areas.add(area1);
        areas.add(area2);

        //写入数据到工作簿对象中
        Workbook workbook = ExcelWriter.exportData(areas);

        //以文件形式输出工作簿对象
        FileOutputStream fileOutputStream = null;
        String path = "C:\\Users\\260408\\Desktop\\1.xls";
        File file = new File(path);
        if (!file.exists()){
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
        fileOutputStream.flush();

        System.out.println("——————————已生成excel文件——————————");

        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        if (workbook != null) {
            workbook.close();
        }
    }

}
