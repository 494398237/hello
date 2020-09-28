package com.service;

import com.domain.Students;

import java.util.List;

/**
 * @author yang
 * @date 2020/9/20 0020 - 15:00
 */
public interface StudentsService {
    public Students getById(String id);
    public void save(Students s);

    List<Students> getAll();
}
