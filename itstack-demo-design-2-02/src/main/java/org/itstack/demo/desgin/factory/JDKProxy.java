package org.itstack.demo.desgin.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * JDK代理，抽象工厂
 */
public class JDKProxy {
    /**
     * 获取代理
     * @param interfaceClass 接口类的class文件
     * @param cacheAdapter 缓存适配器
     * @param <T> 泛形
     * @return
     * @throws Exception
     */
    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter cacheAdapter) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = interfaceClass.getInterfaces();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{classes[0]}, handler);
    }

}
