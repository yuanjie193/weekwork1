package com.youname.dao;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.youname.common.MyRowMapper;
import com.youname.pojo.Games;
import com.youname.pojo.Users;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class UsersDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //查找是否有此用户
    public int selectByUName(String uname) {
            String sql = "select uname from users where uname=?";
             List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, uname);
             if(maps.size()==0){
                 return 0;
             }
             return 1;
    }
    //注册
    public int register(String uname,String password) {
        int i=0;
        String sql = "insert into users values(null,?,?,0)";
        i=jdbcTemplate.update(sql,uname,password);
        return i;
    }
    //登录
    public int selectByUNameAndPassword(String uname,String password) {
        String sql = "select uid,uname,score from users where uname=? and password=?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, uname, password);
        if(maps.size()== 0){
            return 0;
        }
        return 1;
    }

    public String getSx(String sx) {
        String sql = "select sxname from youname where sx=?";
        /*String sql2 = "select mname from youname where month=?";
        String sql3 = "select xzname from youname where xz=?";*/
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, sx);
        for (Map<String, Object> map : maps) {
            for (String s : map.keySet()) {
                 return (String) map.get(s);
            }
        }
        return null;
    }
    public String getmonth(String month) {
        String sql2 = "select mname from youname where month=?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql2, month);
        for (Map<String, Object> map : maps) {
            for (String s : map.keySet()) {
                return (String) map.get(s);
            }
        }
        return null;
    }
    public String getxz(String xz) {
        String sql3 = "select xzname from youname where xz=?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql3, xz);
        for (Map<String, Object> map : maps) {
            for (String s : map.keySet()) {
                return (String) map.get(s);
            }
        }
        return null;
    }
}
