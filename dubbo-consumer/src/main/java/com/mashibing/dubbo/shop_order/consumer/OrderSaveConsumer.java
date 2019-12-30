package com.mashibing.dubbo.shop_order.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mashibing.dubbo.shop_order.interfaces.OrderSaveInterface;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class OrderSaveConsumer {
    @Reference(version = "1.0.0")
    OrderSaveInterface orderSaveInterface;
    public String save(){
        String saveInfo=orderSaveInterface.save();
       return orderSaveInterface.save();
    }
}
