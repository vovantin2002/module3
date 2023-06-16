package com.example.bai_2.service;

import org.springframework.ui.Model;

public interface ICaculatorService {
    void caculator(int num1, int num2, String button, Model model);
}
