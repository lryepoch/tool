package com.base.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 客户端
 */
public class Client {
	public static void main(String[] args) {
		try {
			//1.创建Socket，指定服务器端的地址和端口
			Socket socket = new Socket("localhost", 8888);
			
			//2.获取输出流，向服务器发送信息
			OutputStream outputStream =socket.getOutputStream();//字节输出流
			PrintWriter pw = new PrintWriter(outputStream);//字节流包装打印流
			pw.write("用户名：admin，密码：123");
			pw.flush();
			
			socket.shutdownOutput();//关闭输出流
			
			//3.创建输入流，接收服务端响应的信息
			InputStream is =socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info=null;
			while((info=br.readLine())!=null){
				System.out.println("我是客户端，服务端说："+info);
			}
			
			//4.关闭资源
			br.close();
			is.close();
			
			pw.close();
			outputStream.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
