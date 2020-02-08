package com.youname.service;


import com.youname.common.ResponseCode;

public interface UsersService {
     ResponseCode register(String uname, String password);
     ResponseCode login(String uname, String password);

    ResponseCode games(String sx, String month, String xz);
}
