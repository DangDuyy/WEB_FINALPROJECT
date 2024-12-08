package com.group8.alomilktea.controller.manager;

import com.group8.alomilktea.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.NumberFormat;
import java.util.Locale;

@Controller
public class ManagerDashboardController {
    @Autowired(required = true)
    IOrderService orderService;
    @RequestMapping("/manager")
    public String dashboard(ModelMap model){
        Locale localeVietnam = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(localeVietnam);

        model.addAttribute("reMonth",currencyFormatter.format(orderService.reOnCurrentMonth()));
        model.addAttribute("reYear",currencyFormatter.format(orderService.reOnCurrentYear()));
        model.addAttribute("reQuarter",currencyFormatter.format(orderService.reOnCurrentQuarter()));
        model.addAttribute("rateCom",orderService.rateCom());

        model.addAttribute("totalMontly", orderService.getMonthlyTotal());
        model.addAttribute("totalQuarter", orderService.getQuarterTotal());

        return "manager/dashboard";
    }
}
