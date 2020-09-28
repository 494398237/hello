package com.dao;

import com.domain.Students;

import java.util.List;

/**
 * @author yang
 * @date 2020/9/20 0020 - 14:49
 */
public interface StudentsDao {
    public Students getById(String id);
    public void save(Students s);

    List<Students> getAll();


    Students select1(Students s);

    Students select2(Students s);

    Students getByname(String 杨启莹);

    List<Students> select3(String[] arr);
}
