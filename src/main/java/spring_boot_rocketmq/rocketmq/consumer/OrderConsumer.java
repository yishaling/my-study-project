package spring_boot_rocketmq.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(topic = "group_order",consumerGroup = "cost")
public class OrderConsumer implements RocketMQListener {
    @Override
    public void onMessage(Object message) {

    }
}
