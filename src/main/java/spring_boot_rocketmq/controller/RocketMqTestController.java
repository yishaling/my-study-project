package spring_boot_rocketmq.controller;

import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import spring_boot_rocketmq.rocketmq.producer.OrderProducer;

import java.util.function.Function;

@RestController
public class RocketMqTestController {
    @Autowired
    OrderProducer orderProducer ;
    @GetMapping("/mq/test/send")
    public String testMQ(){
        orderProducer.sendAsyncMsg("this is request msg ", (sendResult -> {

            System.out.println(sendResult.getSendStatus());;
            return null;
        }));
        return "was send";
    }
}
