package com.example.bai_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;


@Controller
public class SandwichController {
    @RequestMapping("")
    public String save() {
        //...
        return "index";
    }

    @RequestMapping("/save")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiment, Model model) {
        if (condiment==null) {
            model.addAttribute("result", "vui long chon da vi! ");
        } else {
            model.addAttribute("result", "Danh sach da vi da chon: " + Arrays.toString(condiment));
        }
        return "index";
    }
}
