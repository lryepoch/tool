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
    /*----------1--------*/
    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        try {
            props.load(MsgProducer.class.getResourceAsStream("/producer.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //读取配置文件
        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++) {
            String msg = "---------" + i + "--------";
            producer.send(new ProducerRecord<>("lytest", i + "", msg));
            System.out.println("生产数据 key：value -> " + i + "：" + msg);
            Thread.sleep(1000);
        }
        producer.close();
    }




    /*-------2.单例模式-----*/
    private volatile static MsgProducer instance;
    private MsgProducer(){}
    public static KafkaProducer producer = null;
    public static MsgProducer getInstance(){
        synchronized (KafkaProducer.class){
            if (instance==null){
                instance = new MsgProducer();
                instance.init();

            }
        }
        return instance;
    }

    private void init() {
        Properties properties = new Properties();
        try {
            properties.load(instance.getClass().getResourceAsStream("/producer.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        producer = new KafkaProducer(properties);
    }

    //外部调用方法
    private void sendMessage(String topic, String key, String message){
        producer.send(new ProducerRecord(topic, key, message));
        producer.flush();
    }
}
