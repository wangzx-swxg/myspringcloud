package com.hzx.springcloud;

import com.hzx.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class CloudConsumerOrder80Main {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder80Main.class, args);
        System.out.println("启动成功");
    }
}
