package com.base.socket.demo2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lryepoch
 * @date 2021/7/9 17:20
 * @description TODO 服务端改进：为了能让一个服务器端程序能同时为多个客户提供服务，可以使用多线程机制，每个客户端的请求都由一个独立的线程进行处理。
 */
public class SocketServerMulti {
    public static void main(String[] args) throws IOException {

        int port = 7000;
        int clientNo = 1;

        ServerSocket serverSocket = new ServerSocket(port);

        //创建线程池
        ExecutorService exec = Executors.newCachedThreadPool();

        try {
            while (true) {
                Socket socket = serverSocket.accept();
                exec.execute(new SingleServer(socket, clientNo));
                clientNo++;
            }
        } finally {
            serverSocket.close();
        }
    }
}

class SingleServer implements Runnable {

    private Socket socket;
    private int clientNo;

    public SingleServer(Socket socket, int clientNo) {
        this.socket = socket;
        this.clientNo = clientNo;
    }

    @Override
    public void run() {

        try {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

            do {
                double length = dis.readDouble();
                System.out.println("从客户端" + clientNo + "接收到的边长数据为：" + length);
                double result = length * length;
                dos.writeDouble(result);
                dos.flush();

            } while (dis.readInt() != 0);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("与客户端"+clientNo+"通信结束");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
