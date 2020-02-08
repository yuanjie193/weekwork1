package com.youname.common;


import com.youname.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyRowMapper implements RowMapper<Users> {
    private Users u;
    public Users mapRow(ResultSet resultSet, int i) throws SQLException {
        u.setUid(resultSet.getInt("uid"));
        u.setUname(resultSet.getString("uname"));
        u.setPassword(resultSet.getString("password"));
        u.setScore(resultSet.getInt("score"));
        return u;
    }
}
