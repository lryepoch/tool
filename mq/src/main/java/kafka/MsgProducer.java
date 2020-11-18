package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.util.Properties;

/**
 * @author lryepoch
 * @date 2020/11/18 11:04
 * @description TODO 生产者
 */
public class MsgProducer {
    public static void main(String[] args) {

        Properties props = new Properties();

        try {
            props.load(MsgProducer.class.getResourceAsStream("/producer.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //读取配置文件
        Producer<String, String> producer = null;
        try {
            producer = new KafkaProducer<>(props);
            for (int i = 0; i < 100; i++) {
                String msg = "---------" + i + "--------";
                producer.send(new ProducerRecord<>("lytest", i + "", msg));
                System.out.println("生产数据 key：value -> " + i + "：" + msg);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}
