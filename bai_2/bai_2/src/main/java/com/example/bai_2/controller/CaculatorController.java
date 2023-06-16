package com.example.bai_2.controller;

import com.example.bai_2.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CaculatorController {
    @Autowired
    private ICaculatorService caculatorService;

    @RequestMapping("")
    public String caculator() {
        return "index";
    }

    @RequestMapping("caculator")
    public String caculator(
            @RequestParam("num1") int num1,
            @RequestParam("num2") int num2,
            @RequestParam("caculator") String button, Model model) {
        caculatorService.caculator(num1, num2, button, model);
        return "index";
    }
}
