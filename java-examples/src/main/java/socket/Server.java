package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP的Socket通信，
 * 服务器端
 * @author Administrator
 *
 */
public class Server {
	public static void main(String[] args) {
		try {
			//1.创建一个服务器端的Socket，指定绑定的端口，并且监听此端口；
			ServerSocket serverSocket = new ServerSocket(8888);
			//2.调用accept方法开始监听，等待客户端的连接
			System.out.println("**服务端即将启动，等待客户端连接**");
			Socket socket = serverSocket.accept();
			//3.获取输入流，并且读取客户端信息
			InputStream is = socket.getInputStream();//字节输入流
			InputStreamReader isr = new InputStreamReader(is);//将字节流转换为字符流，提高读取性能
			BufferedReader br = new BufferedReader(isr);//为输入流添加缓冲
			
			String info=null;
			while((info=br.readLine())!=null){//循环读取客户端信息
				System.out.println("我是服务端，客户端说："+info);
			}
			
			socket.shutdownInput();//关闭输入流
			
			//4.获取输出流，响应客户端请求
			OutputStream os=socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);//包装为打印流
			pw.write("欢迎您！");
			pw.flush();//调用flush方法将缓冲输出
			
			//5.关闭资源
			pw.close();
			os.close();
			
			br.close();
			isr.close();
			is.close();
			socket.close();
			serverSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
