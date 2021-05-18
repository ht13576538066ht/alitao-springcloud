package com.mao.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Author: Administrator
 * Date: 2021/5/5 14:33
 * Description: 注册RestTemplate到容器中
 */
@Configuration
public class ConfigBean {// @Configuration -- spring applicationContext.xml

    // 配置负载均衡 实现RestTemplate
    // IRule
    // RoundRobinRule：轮询
    // RandomRule： 随机
    // AvailabilityFilteringRule : 会先过滤掉跳闸，崩溃，访问故障的服务，对剩下的进行轮询
    // WeightedResponseTimeRule：根据权重来判断应该访问哪个服务
    // RetryRule：会先按照轮询获取服务，如果服务获取失败，则会在指定的时间内进行重试
    @Bean
    @LoadBalanced // Ribbon实现负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
