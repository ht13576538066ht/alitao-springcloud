package com.mao.myRule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Administrator
 * Date: 2021/5/6 22:40
 * Description: 自己的路由组件算法
 */
@Configuration
public class LloamRule {

    @Bean
    public IRule myRule(){
        return new LloamRandomRule();// 默认是轮询，现在我们定义为 自己的 LloamRandomRule
    }
}
