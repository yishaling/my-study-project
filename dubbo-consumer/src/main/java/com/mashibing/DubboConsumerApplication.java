package com.mashibing;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.alibaba.fastjson.JSONObject;
import com.mashibing.http.HttpClientUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@EnableDubboConfiguration
@SpringBootApplication
public class DubboConsumerApplication {
  static   ExecutorService service= Executors.newFixedThreadPool(64);
  static Semaphore semaphore=new Semaphore(256);
    public static void main(String[] args) throws InterruptedException {
        for(;;){
            semaphore.acquire();
            service.submit(()->{

                try {
                    JSONObject jsonObject = HttpClientUtil.sendGet("http://athena-dispatch.maoniuchuxing.com/ws/v2.8/statistics/get-distributor-cost-all-count-info?startDate=1970-01-01&endDate=2099-01-01", new HashMap());
                    System.out.println(jsonObject.toJSONString());
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            });

        }

//        SpringApplication.run(DubboConsumerApplication.class);
    }

}
