package com.mao.springcloud;

import com.mao.myRule.LloamRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Author: Administrator
 * Date: 2021/5/5 14:47
 * Description: 消费者主启动类
 */
// Ribbon 和Eureka 整合以后，客户端可以直接调用，不用IP地址和端口号
@SpringBootApplication
@EnableEurekaClient
// 在微服务启动的时候就能去加载我们自定义Ribbon类
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = LloamRule.class)// 开启负载均衡，并指定自定义的规则
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class,args);
    }
}
