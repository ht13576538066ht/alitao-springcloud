package com.mao.springcloud.controller;

import com.mao.springcloud.pojo.Dept;
import com.mao.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
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

    // 理解：消费者， 不应该有 service 层
    // RestTemplate ...... 模板有很多的方法供我们直接调用就可以了 注册到容器中
    // （url,Class<T> responseType, 实体：Map<String, ?> uriVariables)
//    @Autowired
//    private RestTemplate restTemplate; // 提供多种便捷访问远程 http 服务的方法，简单的 Restful 服务模板
    // 这里使用feign，注入api中的客户端接口 DeptClientService
    @Autowired
    private DeptClientService service = null;

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return service.addDept(dept);
    }

    @RequestMapping("/consumer/dept/get/{deptno}")
    public Dept get(@PathVariable("deptno")Long deptno){
        return service.queryById(deptno);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return service.queryAll();
    }

}
