package com.mao.springcloud.service;

import com.mao.springcloud.pojo.Dept;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Author: Administrator
 * Date: 2021/5/7 21:22
 * Description:
 */
// @FeignClient ：为服务客户端注解，value：指定为服务的名字，这样就可以使Feign客户端直接找到对应的微服务
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @GetMapping("/dept/get/{deptno}")
    public Dept queryById(@PathVariable("deptno") Long deptno);
    @GetMapping("/dept/list")
    public List<Dept> queryAll();
    @PostMapping("/dept/add")
    public boolean addDept(Dept dept);
}
