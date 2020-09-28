package com.test;

import com.dao.StudentsDao;
import com.domain.Students;
import com.util.SqlSessionUtil;

import java.util.List;

/**
 * @author yang
 * @date 2020/9/26 0026 - 16:54
 */
public class Test2 {
    public static void main(String[] args) {
        StudentsDao studentDao = SqlSessionUtil.getSession().getMapper(StudentsDao.class);//动态代理的方式，自动创建Dao实现类
//        Students s = new Students();
////        s.setName("志");
////        //测试
////       Students s1= studentDao.select1(s);
////        System.out.println(s1);
        //传递数组
        String arr[]={"A001","A002","A003"};
        List<Students> sList=studentDao.select3(arr);
        for (Students s : sList) {
            System.out.println(s);
        }

    }
}

