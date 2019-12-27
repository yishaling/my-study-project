package rocketmq.productor;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import rocketmq.common.RocketStaticConfig;

public final class RocketTransactionProducer {
    static TransactionMQProducer producer = new TransactionMQProducer("mq_hero_group");

    private RocketTransactionProducer() throws MQClientException {
    }
    public static void startProducer() throws MQClientException {
        producer.setNamesrvAddr(RocketStaticConfig.NAME_SRV_ADDRESS);
        /**
         * 加入事务监听器
         */
        producer.setTransactionListener(new TransactionListener() {
            /**
             * 在方法中执行本地事务
             * @param msg
             * @param arg
             * @return
             */
            @Override
            public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
                int a=Math.round(1000);
                if(a==1){
                    //回滚
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                }else if (a==2){
                    // 提交
                    return LocalTransactionState.COMMIT_MESSAGE;
                }else{
                    //再回查  过几秒钟会去执行回调  checkLocalTransaction();
                    return LocalTransactionState.UNKNOW;
                }


            }

            /**
             * 事务回查
             * 可以
             * @param msg
             * @return
             */
            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt msg) {
                // 同样的 如上
                int a=Math.round(1000);
                if(a==1){
                    //回滚
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                }else if (a==2){
                    // 提交
                    return LocalTransactionState.COMMIT_MESSAGE;
                }
                return LocalTransactionState.ROLLBACK_MESSAGE;
            }
        });
        //mq延时
//        producer.setRetryTimesWhenSendAsyncFailed(5);
        producer.start();
    }

    public static void sendMsg(String msgInfo) throws Exception {
        //创建消息体
        Message msg = new Message("hero_topic" /* Topic */, "TagA" /* Tag */, (msgInfo).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
        );
        msg.putUserProperty("i", "5");
        //异步发送消息（会做broker的轮训发送）
        producer.send(msg, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
            }

            @Override
            public void onException(Throwable e) {
                System.out.println("onException");
            }
        });
    }
}
