package com.youname.service.impl;

import com.youname.common.ResponseCode;
import com.youname.dao.UsersDao;
import com.youname.pojo.Games;
import com.youname.pojo.Users;
import com.youname.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
   @Autowired
   private UsersDao ud;
   @Autowired
   private Games g;
    //验证是否之前注册过
    public ResponseCode register(String uname,String password) {
        //非空判断
        if(uname == null || "".equals(uname)){
            return ResponseCode.toDefeated("你输入的数据有误！请重新输入");
        }
        if(password == null || "".equals(password)){
            return  ResponseCode.toDefeated("你输入的数据有误！请重新输入");
        }
        //查找是否存在该用户
       int a = ud.selectByUName(uname);
        if(a != 0){
            return ResponseCode.toDefeated("该用户已存在！");
        }
        //注册用户
        int register = ud.register(uname, password);
        if(register==0){
            return ResponseCode.toDefeated("注册失败！");
        }
        return ResponseCode.toSuccess("注册成功");
    }
  //用户登录
    public ResponseCode login(String uname, String password) {
        //非空判断
        if(uname == null || "".equals(uname)){
            return ResponseCode.toDefeated("你输入的数据有误！请重新输入");
        }
        if(password == null || "".equals(password)){
            return  ResponseCode.toDefeated("你输入的数据有误！请重新输入");
        }
        //查找是否存在该用户
        int a =ud.selectByUNameAndPassword(uname,password);
        if(a == 0){
            return ResponseCode.toDefeated("用户不存在！");
        }
        return ResponseCode.toSuccess("登录成功" );
    }

    @Override
    public ResponseCode games(String sx, String month, String xz) {

        //非空判断
        if(sx == null || "".equals(sx)){
            return ResponseCode.toDefeated("你输入的数据有误！请重新输入");
        }
        if(month == null || "".equals(month)){
            return  ResponseCode.toDefeated("你输入的数据有误！请重新输入");
        }
        if(xz == null || "".equals(xz)){
            return  ResponseCode.toDefeated("你输入的数据有误！请重新输入");
        }
        g.setSxname(ud.getSx(sx));;
        g.setMname(ud.getmonth(month));
        g.setXzname(ud.getxz(xz));
        return ResponseCode.toSuccess(g);
    }
}
