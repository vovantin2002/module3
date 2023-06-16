package com.example.bai_2.controller;

import com.example.bai_2.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @GetMapping("")
    public String search() {
        return "index";
    }

    @Autowired
    private IDictionaryService dictionaryService;

    @PostMapping("/dictionary")
    public String search(@RequestParam("tu") String tu, Model model) {
        model.addAttribute("result", "kết quả là: " + dictionaryService.findDictionary(tu));
        return "index";
    }
}
