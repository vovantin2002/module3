//package com.example.bai_6.controller;
//
//import com.example.bai_6.model.Category;
//import com.example.bai_6.service.ICategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//@Controller
//@RequestMapping("/category")
//public class CategoryController {
//    @Autowired
//    private ICategoryService categoryService;
//
//    @GetMapping("")
//    public String displayCategory(Model model) {
//        model.addAttribute("category", categoryService.getCategory());
//        return "category/listc";
//    }
//
//
//    @PostMapping("/createc")
//    public String createc(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
//        categoryService.create(category);
//        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công. ");
//        return "redirect:/category";
//    }
//
//    @GetMapping("/deletec/{id}")
//    public String deletec(@PathVariable int id, RedirectAttributes redirectAttributes) {
//        if (categoryService.delete(id)) {
//            redirectAttributes.addFlashAttribute("msg", "Xóa thành công. ");
//        } else {
//            redirectAttributes.addFlashAttribute("msg", "Không tìm thấy id. ");
//        }
//        return "redirect:/category";
//    }
//
//    @GetMapping("/editc/{id}")
//    public String showFormEditc(@PathVariable int id, Model model) {
//        model.addAttribute("category", categoryService.showFormEdit(id));
//        return "category/editc";
//    }
//
//
//
//    @GetMapping("/createc")
//    public String showFormCreatec(Model model) {
//        model.addAttribute("category", new Category());
//        return "category/createc";
//    }
//
//    @PostMapping("/editc")
//    public String editc(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
//        if (categoryService.edit(category)) {
//            redirectAttributes.addFlashAttribute("msg", "Sửa thành công. ");
//        } else {
//            redirectAttributes.addFlashAttribute("msg", "Không tìm thấy id. ");
//        }
//        return "redirect:/category";
//    }
//}
