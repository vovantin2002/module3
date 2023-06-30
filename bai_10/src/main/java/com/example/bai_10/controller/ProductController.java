package com.example.bai_10.controller;

import com.example.bai_10.model.Cart;
import com.example.bai_10.model.Product;
import com.example.bai_10.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop", "products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/subtract/{id}")
    public String subtractToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.subtractProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.subtractProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional != null) {
            model.addAttribute("products", productOptional);
        } else {
            model.addAttribute("msg", "khong tim thay id.");
        }
        return "/detail";
    }

    @GetMapping("/payment")
    public String payment(@ModelAttribute Cart cart, Model redirectAttributes) {
        cart.payment();
        redirectAttributes.addAttribute("msg", "Thanh toan thanh cong.");
        return "redirect:/shop";
    }
}