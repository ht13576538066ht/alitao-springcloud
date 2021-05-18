package com.mao.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Author: Administrator
 * Date: 2021/5/5 14:47
 * Description: 消费者主启动类
 */
// Ribbon 和Eureka 整合以后，客户端可以直接调用，不用IP地址和端口号
@SpringBootApplication
@EnableEurekaClient // 开启Eureka客户端
@EnableFeignClients(basePackages = {"com.mao.springcloud"})
public class FeignDeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer_80.class,args);
    }
}
