package com.service.impl;

import com.dao.StudentsDao;
import com.domain.Students;
import com.service.StudentsService;
import com.util.SqlSessionUtil;

import java.util.List;

/**
 * @author yang
 * @date 2020/9/20 0020 - 15:01
 */
public class StudentServiceImpl implements StudentsService {
    //调用dao层，dao层都是写到成员变量上
    private StudentsDao studentsDao= SqlSessionUtil.getSession().getMapper(StudentsDao.class);//利用mybatis创建代理类
    @Override
    public Students getById(String id) {
        return studentsDao.getById(id);
    }

    @Override
    public void save(Students s) {
        studentsDao.save(s);
    }

    @Override
    public List<Students> getAll() {
        return studentsDao.getAll();
    }
}
