package kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author lryepoch
 * @date 2020/11/18 11:04
 * @description TODO 消费者
 */
public class MsgConsumer {
    public static void main(String[] args) {

        //读取配置文件
        Properties props=new Properties();

        try {
            props.load(MsgConsumer.class.getResourceAsStream("/consumer.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        //指定消费的topic
        consumer.subscribe(Arrays.asList("lytest"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s, headers = %s%n", record.offset(), record.key(), record.value(), record.headers());
            }
        }
    }
}

