package com.mao.springcloud.controller;

import com.mao.springcloud.pojo.Dept;
import com.mao.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Administrator
 * Date: 2021/5/5 13:57
 * Description: 部门controller层
 */
// 提供 Restful 服务
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{deptno}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("deptno") Long deptno){
        Dept dept = deptService.queryById(deptno);

        if(dept == null){
            throw new RuntimeException("id=>" + deptno + ",不存在该用户，或者信息无法找到");
        }
        return dept;
    }

    // 备选方法
    public Dept hystrixGet(@PathVariable("deptno") Long deptno){
        return new Dept().setDeptno(deptno)
                .setDname("id=>"+deptno+"没有对应的信息，null--@Hystrix")
                .setDb_source("no this database in MySQL");
    }
}
