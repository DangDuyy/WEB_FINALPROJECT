package com.group8.alomilktea.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class DashboardController {
    @RequestMapping("")
    public String dashboard(ModelMap modelMap){
        return "admin/index";
    }
}
