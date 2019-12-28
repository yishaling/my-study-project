package spring_boot_rocketmq.rocketmq.producer;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OrderProducer {
    @Autowired
    RocketMQTemplate rocketMQTemplate;
    public void sendAsyncMsg(String msg , Function<Object,SendResult> function){
        Message rocketMsg=new Message();
        // String destination, Message<?> message, SendCallback sendCallback
        rocketMQTemplate.asyncSend("",rocketMsg,new SendCallback(){

            @Override
            public void onSuccess(SendResult sendResult) {
                function.apply(sendResult);
            }

            @Override
            public void onException(Throwable throwable) {

            }
        });
    }
}
