package com.itdr2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IndexDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int updateByName(String aname, double money) {
        String sql = "update users set score = score-? where uname=?";
        int update = jdbcTemplate.update(sql, money, aname);
        return update;
    }
    public int updateByName2(String aname, double money) {
        String sql = "update users set score = score+? where uname=?";
        int update = jdbcTemplate.update(sql, money, aname);
        return update;
    }
}
