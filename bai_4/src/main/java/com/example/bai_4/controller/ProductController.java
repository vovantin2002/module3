package com.example.bai_4.controller;

import com.example.bai_4.model.Product;
import com.example.bai_4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
//@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String display(Model model) {
        List<Product> productList = productService.display();
        model.addAttribute("productList", productList);
        return "/list";
    }

    @GetMapping("/showFormCreate")
    public String showFormCreate(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        productService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công. ");
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Product product = productService.detail(id);
        model.addAttribute("product", product);
        return "/detail";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable int id, Model model) {
        Product product = productService.showProductUpdate(id);
        model.addAttribute("product", product);
        return "/edit";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        List<Product> productList = productService.searchProductByName(name);
        model.addAttribute("productList", productList);
        return "/list";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.create(product);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công. ");
        return "redirect:/";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.update(product);
        redirectAttributes.addFlashAttribute("msg", "Cập nhật thành công. ");
        return "redirect:/";
    }
}
