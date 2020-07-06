package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

//文件读取
public class FileInput {
	public static void main(String[] args) {
		File file = new File("D:\\temp\\day.txt");
		try {
			FileInputStream f = new FileInputStream(file);
			InputStreamReader i = new InputStreamReader(f,"utf-8");
			BufferedReader b = new BufferedReader(i);
			
			String line;//用来保存读取到的数据
			while((line=b.readLine())!=null){
				System.out.println(line);
			}
			b.close();
			i.close();
			f.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
