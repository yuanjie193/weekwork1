package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;

public interface UsersService {
     ResponseCode selectByUName(String uname);
     ResponseCode register(String uname,String password);
}
