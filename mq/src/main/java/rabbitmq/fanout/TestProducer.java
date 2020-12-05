package rabbitmq.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author lryepoch             producer->broker->exchange->bindings->queues->consumer
 * @date 2020/5/22 17:55
 * @description TODO exchange=广播模式，消息来了，会发给所有的队列~
 */
public class TestProducer {
    public final static String EXCHANGE_NAME = "fanout_exchange";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //判断服务器是否启动
//        RabbitMQUtil.checkServer();

        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        //设置RabbitMQ地址
        factory.setHost("localhost");

        //创建一个新的连接
        Connection connection = factory.newConnection();

        //创建一个通道
        Channel channel = connection.createChannel();

        //交换机声明(参数为：交换机名称；交换机类型)
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        for (int i = 0; i < 100; i++) {
            String message = "direct消息" + i;

            //发送消息到队列中
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
            System.out.println("发送消息：" + message);

            Thread.sleep(1000);
        }
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
