package com.group8.alomilktea.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = {"","/","home","trang-chu"})
@Controller
public class HomeController{

    @GetMapping()
    public String trangchu(){
        return "web/billy/index";
    }
}
