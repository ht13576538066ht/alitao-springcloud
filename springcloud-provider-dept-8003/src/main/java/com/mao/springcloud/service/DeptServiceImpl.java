package com.mao.springcloud.service;

import com.mao.springcloud.dao.DeptDao;
import com.mao.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Administrator
 * Date: 2021/5/5 13:53
 * Description: 实现曾
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;
    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryById(Long deptno) {
        return deptDao.queryById(deptno);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }
}
