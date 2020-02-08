package com.itdr2.controller;

import com.itdr2.service.IndexService;
import com.itdr2.service.impl.IndexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;
    public void tm(String aname,String bname,double money){
        String s =indexService.tm(aname,bname,money);
        System.out.println(s);
    }
}
