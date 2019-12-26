package rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.impl.consumer.DefaultMQPullConsumerImpl;
import org.apache.rocketmq.client.impl.producer.DefaultMQProducerImpl;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class RocketMqConsumer {

    private static final DefaultMQPushConsumer consumer=new DefaultMQPushConsumer("mq_hero_group");
    public static void startConsumer() throws Exception {
        consumer.setNamesrvAddr("127.0.0.1:9876");
        // 订阅topic
        consumer.subscribe("hero_topic","TagA || TagC || TagD");
        // 从哪个消息开始读
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.setMessageModel(MessageModel.CLUSTERING);
        consumer.registerMessageListener(
                new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for(MessageExt msg:msgs){
                    System.out.println(new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
//        consumer.registerMessageListener(
//                new MessageListenerOrderly() {
//
//                    @Override
//                    public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
//                        for(MessageExt msg:msgs){
//                            System.out.println(new String(msg.getBody()));
//                        }
//                        return ConsumeOrderlyStatus.SUCCESS;
//                    }
//                });
        consumer.start();
    }
}
