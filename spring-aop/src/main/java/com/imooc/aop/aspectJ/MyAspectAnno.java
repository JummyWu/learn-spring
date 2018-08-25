package com.imooc.aop.aspectJ;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

//切面类
@Aspect
public class MyAspectAnno {


    @Pointcut(value = "execution(* com.imooc.aop.aspectJ.ProductDao.save(..))")
    private void myPointcut1(){}


    @Before(value="myPointcut1()")
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知"+ joinPoint);
    }

    @AfterReturning(value="execution(* com.imooc.aop.aspectJ.ProductDao.update(..))", returning = "result")
    public void afterReturning(Object result){
        //result 是目标方法返回值
        System.out.println("后置通知"+ result);
    }

    @Around(value="execution(* com.imooc.aop.aspectJ.ProductDao.detele(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕置通知前"+ joinPoint);
        Object obj = joinPoint.proceed(); //执行目标方法
        System.out.println("环绕置通知后"+ joinPoint);
        return  obj;
    }


    @AfterThrowing(value="execution(* com.imooc.aop.aspectJ.ProductDao.find(..))", throwing = "e")
    public void afterThrowing(Throwable e){
        System.out.println("异常通知"+ e);
    }

    @After(value="execution(* com.imooc.aop.aspectJ.ProductDao.findAll(..))")
    public void after(){
        System.out.println("最终通知");
    }

}
