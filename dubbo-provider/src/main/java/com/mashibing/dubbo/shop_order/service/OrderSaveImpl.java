package com.mashibing.dubbo.shop_order.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.mashibing.dubbo.shop_order.interfaces.OrderSaveInterface;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = OrderSaveInterface.class,version = "1.0.0")
public class OrderSaveImpl  implements OrderSaveInterface {
     public String save(){
          return "OrderSaveImpl.save-------------------";
     }
}
