package com.test;

import com.domain.Students;
import com.service.StudentsService;
import com.service.impl.StudentServiceImpl;
import com.util.ServiceFactory;

import java.util.List;

/**
 * @author yang
 * @date 2020/9/18 0018 - 19:56
 */
public class Test1 {
    public static void main(String[] args) {
        StudentsService ss= (StudentsService) ServiceFactory.getService(new StudentServiceImpl());
//        Students s=ss.getById("A002");
//        System.out.println(s);
        //查询所有记录
        List<Students> slist=ss.getAll();
        for (Students s : slist) {
            System.out.println(s);
        }

    }
}
