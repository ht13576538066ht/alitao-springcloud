package com.mao.springcloud.service;

import com.mao.springcloud.pojo.Dept;

import java.util.List;

/**
 * Author: Administrator
 * Date: 2021/5/5 13:53
 * Description: 部门Service层
 */
public interface DeptService {

    // 添加部门
    public boolean addDept(Dept dept);
    // 根据ID查询部门
    public Dept queryById(Long deptno);
    // 查询全部部门
    public List<Dept> queryAll();
}
