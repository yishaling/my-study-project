package rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.client.exception.MQClientException;

public final class RocketMqConsumer {
    private static final DefaultMQPushConsumer consumer=new DefaultMQPushConsumer("hero_queue");
    public static void startConsumer() throws MQClientException {
        consumer.setNamesrvAddr("127.0.0.1:9876");
        consumer.setMessageListener(new MessageListener() {
        });
        consumer.start();
    }

}
