package com.itdr.pojo;

import java.util.Date;

public class Users {
    private String username;
    private String password;
    private Integer uid;
    private Date create_time;
    private Date update_time;
    private String user_level;
    private int type;

    public Users(Integer u){
        System.out.println("这是有参构造");
        this.uid = u;
    }
    public Users(){
        System.out.println("这是无参构造");
    }
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getUser_level() {
        return user_level;
    }

    public void setUser_level(String user_level) {
        this.user_level = user_level;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", uid=" + uid +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", user_level='" + user_level + '\'' +
                ", type=" + type +
                '}';
    }
}
