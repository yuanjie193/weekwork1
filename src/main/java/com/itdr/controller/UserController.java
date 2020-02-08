package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.dao.UsersDao;
import com.itdr.pojo.Users;
import com.itdr.service.impl.UsersServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/*")
public class UserController extends HttpServlet {
    UsersServiceImpl us = new UsersServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        String[] split = requestURI.split("/");
        switch (split[split.length-1]){
            case "register":
                register(request,response);
                break;
        }
    }
    //注册用户
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");
        ResponseCode register = us.register(uname, password);
        request.setAttribute("register",register);
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
    //用户登录
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");
        ResponseCode register = us.login(uname, password);

    }
}
