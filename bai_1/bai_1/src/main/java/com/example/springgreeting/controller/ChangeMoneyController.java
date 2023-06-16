package com.example.springgreeting.controller;

import com.example.springgreeting.service.IChangeMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class ChangeMoneyController {
    @Autowired
   private IChangeMoneyService changeMoneyService;

    @PostMapping("chuyendoitiente")
    public String greeting(@RequestParam("vnd") double money, Model model) {
        if (money<0){
            model.addAttribute("result", "số tiền không đúng định dạng ");
        }else {
            model.addAttribute("result", changeMoneyService.changeMoney(money) +"vnđ");
        }
        return "result";
    }
}
