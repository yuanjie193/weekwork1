package com.itdr.service.impl;

import com.itdr.common.ResponseCode;
import com.itdr.dao.UsersDao;
import com.itdr.pojo.Users;
import com.itdr.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsersServiceImpl implements UsersService {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
    UsersDao ud = (UsersDao) ac.getBean("ud");
    //验证是否之前注册过
    public ResponseCode selectByUName(String uname){
        //非空判断
        if(uname == null || "".equals(uname)){
            return ResponseCode.toDefeated("你输入的数据有误！请重新输入");
        }
        //查找是否存在该用户
        return null;
    }
    @Override
    public ResponseCode register(String uname,String password) {
        //非空判断
        if(uname == null || "".equals(uname)){
            return ResponseCode.toDefeated("你输入的数据有误！请重新输入");
        }
        //查找是否存在该用户
        Users u = ud.selectByUName(uname);
        if(u != null){
            return ResponseCode.toDefeated("该用户已存在！");
        }
        //注册用户
        int register = ud.register(uname, password);
        if(register==0){
            return ResponseCode.toDefeated("注册失败！");
        }
        return ResponseCode.toSuccess("注册成功");
    }
}
