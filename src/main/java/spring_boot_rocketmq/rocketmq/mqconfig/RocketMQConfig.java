package spring_boot_rocketmq.rocketmq.mqconfig;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.spring.autoconfigure.RocketMQProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RocketMQConfig {
    @Value("${rocketmq.name-server}")
    String nameServer;
    @Value("${rocketmq.producer.group}")
    String producerGroup;
    @Bean
    @ConditionalOnClass(DefaultMQProducer.class)
    @ConditionalOnMissingBean(DefaultMQProducer.class)
//    @ConditionalOnProperty(prefix = "name-server",value = {"name-server","producer.group"})
  public   DefaultMQProducer  defaultMQProducer(RocketMQProperties properties){
        DefaultMQProducer defaultMQProducer=   new DefaultMQProducer();
        defaultMQProducer.setNamesrvAddr(nameServer);
        defaultMQProducer.setProducerGroup(producerGroup);
        return defaultMQProducer;
    }
}
