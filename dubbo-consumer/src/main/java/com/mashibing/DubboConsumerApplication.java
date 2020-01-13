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
    public static void main(String[] args) throws InterruptedException {

        SpringApplication.run(DubboConsumerApplication.class);
    }

}
