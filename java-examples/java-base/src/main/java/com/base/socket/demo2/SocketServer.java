package com.base.socket.demo2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lryepoch
 * @date 2021/7/9 17:01
 * @description TODO 简单例子：客户端输入正方形的边长，服务器端接收到后计算面积并返回给客户端
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        //端口号
        int port = 7000;
        //创建服务器套接字
        ServerSocket serverSocket = new ServerSocket(port);
        //监听来自客户端的连接
        Socket socket = serverSocket.accept();

        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

        do {
            //接收SocketClient的输出流
            double length = dis.readDouble();
            System.out.println("服务器端收到的边长数据为：" + length);
            double result = length * length;
            //这是输出流，而SocketClinet的输入流接收到啦
            dos.writeDouble(result);
            dos.flush();
        } while (dis.readInt() != 0);

        socket.close();
        serverSocket.close();
    }
}
