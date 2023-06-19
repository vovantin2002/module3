package com.example.bai_2.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class CaculatorService implements ICaculatorService {
    @Override
    public void caculator(int num1, int num2, String button, Model model) {
        switch (button) {
            case "add":
                model.addAttribute("result", "Addition: " + (num1 + num2));
                break;
            case "sub":
                model.addAttribute("result", "Subtraction: " + (num1 - num2));
                break;
            case "mul":
                model.addAttribute("result", "Multiplication: " + (num1 * num2));
                break;
            case "div":
                if (num1 == 0 || num2 == 0) {
                    model.addAttribute("result", "Khong the chia cho 0! ");
                } else {
                    model.addAttribute("result", "Division: " + (num1 / num2));
                }
                break;
            default:
                model.addAttribute("result", "Vui long nhap lai.  ");
                break;
        }
    }
}
