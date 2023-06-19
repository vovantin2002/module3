package com.example.bai_3.controller;

import com.example.bai_3.model.Email;
import com.example.bai_3.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    @Autowired
    private IEmailService emailService;

    @GetMapping("email")
    public String displayEmail(Model model) {
        model.addAttribute("email", emailService.display());
        return "index";
    }

    @PostMapping("email")
    public String updateEmail(@ModelAttribute Email email, Model model) {
        emailService.update(email);
        model.addAttribute("msg", "Cap nhat thanh cong. ");
        return "index";
    }
}
