package rocketmq.productor;

        import org.apache.rocketmq.client.exception.MQClientException;
        import org.apache.rocketmq.client.producer.DefaultMQProducer;

public final class RocketMqProducer {
    static final DefaultMQProducer producer = new
            DefaultMQProducer("hero_queue");

    public static void startProducer() throws MQClientException {
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.setRetryTimesWhenSendAsyncFailed(5);
        producer.start();
    }
    public static void sendMsg(String msg){

    }
}
