package com.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yang
 * @date 2020/9/20 0020 - 13:46
 */
//创建代理类
public class TransactionInvocationHandler implements InvocationHandler {
    //①目标对象，成员变量
    private Object target;
    //②构造方法 ，无论是传统的静态代理模式还是现在的动态代理模式，都需要写成员变量和构造方法。
    public TransactionInvocationHandler(Object target){
        this.target=target;
    }
    //代理类的业务方法。
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session=null;
        Object obj=null;
        try {
            session=SqlSessionUtil.getSession();
            obj = method.invoke(target, args);//处理完业务逻辑。若出现问题，跳到事务回滚处
            //处理业务逻辑完毕后，提交事务，目标对象的方法
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            SqlSessionUtil.myClose(session);
        }
        return obj;
    }
    //获取代理对象
    public  Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
