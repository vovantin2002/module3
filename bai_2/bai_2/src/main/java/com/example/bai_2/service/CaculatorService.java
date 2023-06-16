package com.example.bai_2.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class CaculatorService implements ICaculatorService {
    @Override
    public void caculator(int num1, int num2, String button, Model model) {
        if ("add".equals(button)) {
            model.addAttribute("result", "Addition: " + (num1 + num2));
        } else if (button.equals("sub")) {
            model.addAttribute("result", "Subtraction: " + (num1 - num2));
        } else if (button.equals("mul")) {
            model.addAttribute("result", "Multiplication: " + (num1 * num2));
        } else if (button.equals("div")) {
            if (num1==0||num2==0){
                model.addAttribute("result", "Khong the chia cho 0! ");
            }else {
                model.addAttribute("result", "Division: " + (num1 / num2));
            }
        } else {
            model.addAttribute("result", "Vui long nhap lai.  ");
        }
    }
}
