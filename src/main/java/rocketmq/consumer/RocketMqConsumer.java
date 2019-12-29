package rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.impl.consumer.DefaultMQPullConsumerImpl;
import org.apache.rocketmq.client.impl.producer.DefaultMQProducerImpl;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import rocketmq.common.RocketStaticConfig;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class RocketMqConsumer {

    private static final DefaultMQPushConsumer consumer=new DefaultMQPushConsumer("mq_hero_group");
    public static void startConsumer() throws Exception {
        consumer.setNamesrvAddr(RocketStaticConfig.NAME_SRV_ADDRESS);
        // 订阅topic and  tag 过滤
        consumer.subscribe("hero_topic","TagA || TagC || TagD");
        // 从哪个消息开始读
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.setMessageModel(MessageModel.CLUSTERING);
//        consumer.subscribe("hero_topic", MessageSelector.bySql("i=5"));
        consumer.registerMessageListener(
                new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for(MessageExt msg:msgs){
                    msg.getStoreTimestamp();
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
