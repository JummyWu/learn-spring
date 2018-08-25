package com.imooc.aop.aspectJXml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspectXml {

    //前置通知
    public void before(JoinPoint joinPoint){
        System.out.println("xml 前置通知"+ joinPoint);
    }

    public void afterReturning(Object result){
        System.out.println("xml 后置通知"+ result);
    }

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("xml 环绕置通知1");
        Object obj = joinPoint.proceed();
        System.out.println("xml 环绕置通知2");

        return obj;
    }

    public void afterThrowing(Throwable e){
        System.out.println("xml 异常通知"+ e);
    }

    public void after(){
        System.out.println("xml 最终通知");
    }


}
