package com.youname.controller;

import com.youname.common.ResponseCode;
import com.youname.pojo.Games;
import com.youname.service.UsersService;
import com.youname.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home/*")
@Controller
public class UserController extends HttpServlet {
    static  ApplicationContext applicationContext =new ClassPathXmlApplicationContext("youname.xml");
    static UsersService us = applicationContext.getBean(UsersServiceImpl.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String[] split = requestURI.split("/");
        switch (split[split.length-1]){
            case "register":
                register(request,response);
                break;
            case "login":
                login(request,response);
                break;
            case "games":
                games(request,response);
                break;
            case "backlogin":
                backlogin(request,response);
                System.out.println("请求进来了");
                break;
        }
    }

    //注册用户
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");
        ResponseCode register = us.register(uname, password);
        if(register.getStatus()==200){
            request.setAttribute("register",register);
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            response.getWriter().write(register.getMsg());
        }

    }
    //用户登录
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");
        ResponseCode login = us.login(uname, password);
        if(login.getStatus() == 200){
            request.setAttribute("login",login);
            request.getRequestDispatcher("/home.jsp").forward(request,response);
        }else {
            response.getWriter().write(login.getMsg());
        }
    }
    //用户登录
    public void backlogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
    //开始游戏
    private void games(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sx = request.getParameter("sx");
        String month = request.getParameter("month");
        String xz = request.getParameter("xz");
        ResponseCode games =us.games(sx,month,xz);
        request.setAttribute("games",games.getData());
        request.getRequestDispatcher("/home2.jsp").forward(request,response);
    }
}
