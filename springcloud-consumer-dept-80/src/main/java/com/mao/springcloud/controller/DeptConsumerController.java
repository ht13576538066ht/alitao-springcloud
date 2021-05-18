package com.mao.springcloud.controller;

import com.mao.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Author: Administrator
 * Date: 2021/5/5 14:27
 * Description:
 */
@RestController
public class DeptConsumerController {
//测试git
    // 理解：消费者， 不应该有 service 层
    // RestTemplate ...... 模板有很多的方法供我们直接调用就可以了 注册到容器中
    // （url,Class<T> responseType, 实体：Map<String, ?> uriVariables)
    @Autowired
    private RestTemplate restTemplate; // 提供多种便捷访问远程 http 服务的方法，简单的 Restful 服务模板

    // Ribbon ,我们这里的地址，应该是一个变量，通过服务名来访问
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";
    //http://localhost:8001/dept/list

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{deptno}")
    public Dept get(@PathVariable("deptno")Long deptno){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+deptno,Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }

}
