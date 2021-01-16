package rocketmq.productor;

import com.alibaba.fastjson.JSONArray;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import rocketmq.common.RocketStaticConfig;

import java.util.ArrayList;
import java.util.List;

public final class RocketMqProducer {
    // group 是为集群准备的
    static final DefaultMQProducer producer = new DefaultMQProducer("refund-topic-local");

    public static void startProducer() throws MQClientException {
        producer.setNamesrvAddr(RocketStaticConfig.NAME_SRV_ADDRESS);
        //mq延时
//        producer.setRetryTimesWhenSendAsyncFailed(5);
        //发送失败 去找另外的broker发送
//        producer.setRetryAnotherBrokerWhenNotStoreOK(true);
        //
//        producer.setCallbackExecutor();
        producer.start();
    }

    public static void sendMsg(String msgInfo) throws Exception {
        //创建消息体
        PayRefundDto dto=new PayRefundDto();
        List list=new ArrayList();
        list.add(dto);
        String s = JSONArray.toJSONString(list);
        Message msg = new Message("wx-refund-topic-local" /* Topic */, "refund",(s).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
        );
//        msg.putUserProperty("i","5");
        //异步发送消息（会做broker的轮训发送）
       producer.send(msg,new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println(sendResult.getSendStatus());
            }

            @Override
            public void onException(Throwable e) {
                e.printStackTrace();
                System.out.println("onException");
            }
        });
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
        //设置延迟时间
//        msg.setDelayTimeLevel(1);
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
