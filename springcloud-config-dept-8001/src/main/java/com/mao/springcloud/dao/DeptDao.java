package com.mao.springcloud.dao;

import com.mao.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: Administrator
 * Date: 2021/5/5 13:39
 * Description: 部门dao层接口
 */
@Mapper
@Repository
public interface DeptDao {

    // 添加部门
    public boolean addDept(Dept dept);
    // 根据ID查询部门
    public Dept queryById(Long deptno);
    // 查询全部部门
    public List<Dept> queryAll();
}
