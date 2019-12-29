package spring_boot_rocketmq.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(topic = "order_cost",consumerGroup = "group_order",selectorType = SelectorType.TAG ,selectorExpression = "apply")
public class OrderConsumer implements RocketMQListener {
    @Override
    public void onMessage(Object message) {
        System.out.println(message);
    }
}
