package rocketmq.productor;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;

public final class RocketMqProducer {
    // group 是为集群准备的
    static final DefaultMQProducer producer = new DefaultMQProducer("mq_hero_group");

    public static void startProducer() throws MQClientException {
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.setRetryTimesWhenSendAsyncFailed(5);
        producer.start();
    }

    public static void sendMsg(String msgInfo) throws Exception {
        //创建消息体
        Message msg = new Message("hero_topic" /* Topic */, "TagA" /* Tag */, (msgInfo).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
        );
        //发送消息
        SendResult sendResult = producer.send(msg);
    }

    /**
     * 发送有序消息
     * @param msgInfo
     * @throws Exception
     */
    public static void sendMsgOrderly(String msgInfo,Long msgFlag) throws Exception {
        //创建消息体
        Message msg = new Message("hero_topic" /* Topic */, "TagA" /* Tag */, (msgInfo).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
        );
        /**
         * 默认的是阻塞的
         * this.sendSelectImpl(msg, selector, arg, CommunicationMode.SYNC, null, timeout);
         *msg:消息体
         * MessageQueueSelector：队列选择器
         * msgFlag：标示
         */
        SendResult sendResult = producer.send(msg, new MessageQueueSelector(){

            @Override
            public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                long msgQueueIndex=Long.valueOf(mqs.toString())%mqs.size();
                return mqs.get((int)msgQueueIndex);
            }
        },msgFlag);
    }
}
