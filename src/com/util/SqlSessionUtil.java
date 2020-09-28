package com.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author yang
 * @date 2020/9/19 0019 - 21:00
 */
public class SqlSessionUtil {
    private SqlSessionUtil(){}//构造方法私有化，不让工具类创建对象，直接类名.方法直接调用。
    private static SqlSessionFactory sqlSessionFactory;
    static{
        String resource="mybatis-config.xml";
        InputStream inputStream=null;
        try {
                inputStream= Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        }
        //创建线程共享变量，存放sqlsession
    private static ThreadLocal<SqlSession> t=new ThreadLocal<SqlSession>();
    //获取SqlSession对象
    public  static  SqlSession getSession(){//取得session对象
        SqlSession session=t.get();
        if(session==null){
            session=sqlSessionFactory.openSession();
            t.set(session);
        }
        return  session;
    }

    //关闭SqlSession对象
    public static void myClose(SqlSession session){//关闭session对象
        if (session!=null){//避免出现空指针异常
            session.close();//将连接送回连接池
            t.remove();//将线程送回线程池
        }
    }
}
