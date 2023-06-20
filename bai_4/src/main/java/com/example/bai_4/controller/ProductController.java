package com.example.bai_4.controller;

import com.example.bai_4.model.Product;
import com.example.bai_4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
//@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("")
    public String display(Model model) {
        List<Product> productList = productService.display();
        model.addAttribute("productList", productList);
        return "/list";
    }

    @GetMapping("/showFormCreate")
    public String showFormCreate(Model model) {
        Product product=new Product();
        model.addAttribute("product",product);
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.create(product);
        redirectAttributes.addFlashAttribute("msg", "Them moi thanh cong. ");
        return "redirect:/list";
    }
}
