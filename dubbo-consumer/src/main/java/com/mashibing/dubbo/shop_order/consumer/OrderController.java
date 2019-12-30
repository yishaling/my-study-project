package com.mashibing.dubbo.shop_order.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderSaveConsumer orderSave;
    @GetMapping("/orderSave")
    public String save(){
        return orderSave.save();
    }
}
