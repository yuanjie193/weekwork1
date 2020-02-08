package com.itdr2.config;

import org.aspectj.lang.ProceedingJoinPoint;

//切面类
public class AopDemo {
    public  void befor(){
    System.out.println("这是前置方法，开始切面权限校验");
    }
    public void af(int num){
        System.out.println("开启后置通知：删除"+num);
    }
    public void ar(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("开启环绕前通知");
        Object proceed = joinPoint.proceed();
        System.out.println("开启环绕后通知");
    }
    public void th(Throwable thr){
        System.out.println("开启异常通知："+thr.getMessage());
    }
    public void zz(){
        System.out.println("无论怎么样都开启最终通知");
    }
}
