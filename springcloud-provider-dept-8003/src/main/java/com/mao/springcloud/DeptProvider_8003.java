package com.mao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author: Administrator
 * Date: 2021/5/5 14:05
 * Description: 主启动类
 */
@SpringBootApplication
@EnableEurekaClient // 在启动之后会自己注册到Eureka中
@EnableDiscoveryClient // 开启服务发现
public class DeptProvider_8003 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8003.class,args);
    }
}
