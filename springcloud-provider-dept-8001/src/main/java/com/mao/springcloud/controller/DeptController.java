package com.mao.springcloud.controller;

import com.mao.springcloud.pojo.Dept;
import com.mao.springcloud.service.DeptService;
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
    // 获取一些配置信息，得到具体的微服务
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept){
//        System.out.println(dept.getDname());
        return deptService.addDept(dept);
    }
//    @PostMapping("/dept/test")
//    public Dept test(Dept dept){
//        System.out.println(dept);
////        return deptService.addDept(dept);
//        return dept;
//    }

    @GetMapping("/dept/get/{deptno}")
    public Dept get(@PathVariable("deptno")Long deptno){
        Dept dept = deptService.queryById(deptno);
        if(dept == null){
            throw new RuntimeException("Fail");
        }
        return dept;
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

    // 注册进来的微服务，可以通过服务发现获取一些消息 通过服务端调用某一个请求拿到对应的消息
    @GetMapping("/dept/discovery")
    public Object discovery(){
        // 获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services:" + services);

        // 得到一个具体的微服务信息,通过具体的service ID，applicationName
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri() + "\t" +
                    instance.getServiceId()
            );
        }
        return client;
    }
}
