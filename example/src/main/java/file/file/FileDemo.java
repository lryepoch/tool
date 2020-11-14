package file;

import java.io.File;
import java.io.IOException;


public class FileDemo {
	public static void main(String[] args) {
		//File类,加多一个\转义
		File file = new File("E:\\realdata");
		//File.separator是File的分隔符，系统可以判断出的
		File file1 = new File("E:"+File.separator+"realdata");
		
	//	System.out.println(file.exists());
		
//		if(!file.exists())
		//创建的是一级目录，多级目录可以是file.mkdirs();
//			file.mkdirs();
//		else file.delete();
		
	//判断是不是一个目录
	//	System.out.println(file.isDirectory());
		
	//判断是不是一个文件
	//	System.out.println(file.isFile());

	
		File file2=new File("e:\\tmp3\\dairy.txt");
		//	or	File file2=new File("e:\\tmp3","dairy.txt");

		if(!file2.exists()){
			try {
				file2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else file2.delete();
		
		//File常见API
		System.out.println(file2.getAbsolutePath());
		System.out.println(file2.getName());
		System.out.println(file.getName());
		System.out.println(file2.getParent());
		System.out.println(file2.getParentFile().getAbsolutePath());
		
		
	}
}
