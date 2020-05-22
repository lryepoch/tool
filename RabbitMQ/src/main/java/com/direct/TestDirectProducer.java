package com.direct;

import com.fanout.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author lryepoch
 * @date 2020/5/22 17:55
 * @description TODO
 */
public class TestDirectProducer {
    public final static String QUEUE_NAME="direct_queue";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //判断服务器是否启动
        RabbitMQUtil.checkServer();

        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        //设置RabbitMQ地址
        factory.setHost("localhost");

        //创建一个新的连接
        Connection connection = factory.newConnection();

        //创建一个通道
        Channel channel = connection.createChannel();

        for (int i=0;i<100;i++){
            String message = "direct消息"+i;
            //发送消息到队列中
            channel.basicPublish("", QUEUE_NAME,null,message.getBytes("UTF-8"));
            System.out.println("发送消息："+message);
            Thread.sleep(1000);
        }
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
