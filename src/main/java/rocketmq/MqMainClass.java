package rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import rocketmq.consumer.RocketMqConsumer;
import rocketmq.productor.RocketMqProducer;

public class MqMainClass {
    public static void main(String[] args) throws Exception {
       RocketMqProducer.startProducer();
        RocketMqConsumer.startConsumer();
    }
}
