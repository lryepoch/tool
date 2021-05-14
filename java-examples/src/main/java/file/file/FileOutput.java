package file.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

//文件写入
public class FileOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("D:\\temp\\day.txt");
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(file);
			OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream, "utf-8");
			BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
			bufferedWriter.write("zenggoushishabi" + "\r\n");
			bufferedWriter.write("shidemeicun11111" + "\r\n");
			bufferedWriter.write("66666666666666" + "\r\n");
			
			bufferedWriter.close();
			outputStreamWriter.close();
			fileOutputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println("写入完成");
		}

		
	}

}
