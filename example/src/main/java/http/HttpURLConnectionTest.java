package http;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionTest {

    public static void get(String validateUrl) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(validateUrl);
            //得到connection对象
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            //设置get
            conn.setRequestMethod("GET");
            //连接
            conn.connect();
            //得到响应码
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                //得到响应流
                DataInputStream dis = new DataInputStream(conn.getInputStream());
                //将留转换成字符串
                String result = dis.toString();
                System.out.println(result);
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    public static void post(String validateUrl, String message){
        try {
            URL url = new URL(validateUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置请求方式为post
            conn.setRequestMethod("POST");
            //设置连接超时时间
            conn.setConnectTimeout(1000*60);
            //设置读取超时时间
            conn.setReadTimeout(1000*60);
            //允许写出
            conn.setDoOutput(true);
            //允许写入
            conn.setDoInput(true);
            //不使用缓存//GET支持缓存，POST不支持
            conn.setUseCaches(false);
            //连接
            conn.connect();

            byte[] bytes = message.toString().getBytes("UTF-8");
            conn.getOutputStream().write(bytes);

            if (conn.getResponseCode()==HttpURLConnection.HTTP_OK) {
                InputStream inputStream = conn.getInputStream();
                //将流转换成字符串
                String result = inputStream.toString();
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

}
