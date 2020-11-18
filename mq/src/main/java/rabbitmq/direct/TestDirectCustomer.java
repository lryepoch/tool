package rabbitmq.direct;

import cn.hutool.core.util.RandomUtil;
import rabbitmq.fanout.RabbitMQUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author lryepoch
 * @date 2020/5/22 19:07
 * @description TODO
 */
public class TestDirectCustomer {
    private final static String QUEUE_NAME = "direct_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        final String name = "consumer-"+ RandomUtil.randomString(5);

        RabbitMQUtil.checkServer();

        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        //设置RabbitMQ地址
        factory.setHost("localhost");

        //创建一个新的连接
        Connection connection = factory.newConnection();

        //创建一个通道
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, true, null);

        System.out.println(name+"等待接收消息");

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body,"UTF-8");
                System.out.println(name+"接收到消息'"+message+"'");
            }
        };
        //自动回复队列应答--RabbitMQ中的消息确认机制
        channel.basicConsume(QUEUE_NAME,true,consumer);
    }
}
