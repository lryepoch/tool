package rabbitmq.topic;

import rabbitmq.fanout.RabbitMQUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author lryepoch
 * @date 2020/5/25 9:44
 * @description TODO
 */
public class TestCustomer4USA {
    public final static String EXCHANGE_NAME = "topics_exchange";

    public static void main(String[] args) throws IOException, TimeoutException {
        final String name = "consumer-usa";

//        RabbitMQUtil.checkServer();

        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("localhost");

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        //获取一个临时队列
        String queueName = channel.queueDeclare().getQueue();

        //接收关于usa的信息
        channel.queueBind(queueName, EXCHANGE_NAME, "usa.*");
        System.out.println(name + "等待接受消息");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(name + "接收到消息'" + message + "'");
            }
        };
        //自动回复队列应答--RabbitMQ中的消息确认机制
        channel.basicConsume(queueName, true, consumer);
    }
}
