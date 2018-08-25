package com.imooc.aop.SpringAopAutoProxy;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;


//2.
public class MyBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("前置增强");
    }


}
