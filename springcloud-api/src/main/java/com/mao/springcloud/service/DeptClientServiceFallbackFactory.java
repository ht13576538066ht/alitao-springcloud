package com.mao.springcloud.service;

import com.mao.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: Administrator
 * Date: 2021/5/8 11:17
 * Description:
 */
// 降级
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept queryById(Long deptno) {
                return new Dept().setDeptno(deptno)
                        .setDname("id=>"+deptno+"，没有对应的信息，客户端提供了降级的信息，这个服务现在已经被关闭")
                        .setDb_source("no this database in MySQL");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
