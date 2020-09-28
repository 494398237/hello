package com.util;

/**
 * @author yang
 * @date 2020/9/20 0020 - 14:39
 */
public class ServiceFactory {
    //传递目标对象（实现类），得到代理对象
    public static Object getService(Object service){
        return new TransactionInvocationHandler(service).getProxy();
    }
}
