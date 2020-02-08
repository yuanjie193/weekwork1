package com.itdr.dao;

import com.itdr.pojo.Users;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
public class UsersDao {
        public Users selectByUsernameAndPassword(String username,String password){
            QueryRunner queryRunner =new QueryRunner(new ComboPooledDataSource());
            Users u = null;
            String sql = "select uid,username,password,create_time," +
                    "update_time,user_level,type from user where username=? and password=? ";
            try {
                u = queryRunner.query(sql, new BeanHandler<Users>(Users.class),username,password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return u;
        }
//查找是否有此用户
    public Users selectByUName(String uname) {
            QueryRunner queryRunner =new QueryRunner(new ComboPooledDataSource());
            Users u=null;
            String sql = "select uname from users where uname=?";
        try {
            u = queryRunner.query(sql,new BeanHandler<Users>(Users.class),uname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
    //注册
    public int register(String uname,String password) {
        QueryRunner queryRunner =new QueryRunner(new ComboPooledDataSource());
        int i=0;
        String sql = "insert into users values(null,?,?,0)";
        try {
            i = queryRunner.update(sql, uname, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    //登录
    public Users selectByUNameAndPassword(String uname,String password) {
        QueryRunner queryRunner =new QueryRunner(new ComboPooledDataSource());
        Users u=null;
        String sql = "select uid,uname,score from users where uname=? and password=?";
        try {
            u = queryRunner.query(sql,new BeanHandler<Users>(Users.class),uname,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
}
