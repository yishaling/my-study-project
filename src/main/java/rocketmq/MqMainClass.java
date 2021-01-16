package rocketmq;

import rocketmq.consumer.RocketMqConsumer;
import rocketmq.productor.RocketMqProducer;

public class MqMainClass {
    public static void main(String[] args) throws Exception {
//        RocketMqConsumer.startConsumer();
       RocketMqProducer.startProducer();
////       for(int i=0;i<10;i++){
////             RocketMqConsumer.startConsumer();
////       }
//
        for(int i=0;i<10;++i){
            Thread.sleep(1);
//            byte [] input=new byte[2048];
//            System.in.read(input);
            RocketMqProducer.sendMsg("{}");
        }

    }
}
