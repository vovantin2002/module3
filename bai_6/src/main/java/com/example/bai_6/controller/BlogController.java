//package com.example.bai_6.controller;
//
//import com.example.bai_6.model.Blog;
//import com.example.bai_6.service.IBlogService;
//import com.example.bai_6.service.ICategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.util.List;
//
//
//@Controller
//@RequestMapping("/blog")
//public class BlogController {
//    @Autowired
//    private IBlogService blogService;
//
//    @Autowired
//    private ICategoryService categoryService;
//
//    @GetMapping("")
//    public String display(@PageableDefault(size = 2, sort = "postingDate") Pageable pageable, Model model) {
//        model.addAttribute("blogList", blogService.display(pageable));
//        return "list";
//    }
//
//
//    @GetMapping("/search")
//    public String search(@PageableDefault(size = 2) Pageable pageable, @RequestParam(value = "title", defaultValue = "") String title, Model model) {
//        model.addAttribute("blogList", blogService.findAllByTitle(pageable, title));
//        return "list";
//    }
//
//    @GetMapping("/create")
//    public String showFormCreate(Model model) {
//        model.addAttribute("blog", new Blog());
//        model.addAttribute("categorys", categoryService.getCategory());
//        return "create";
//    }
//
//
//    @GetMapping("/edit/{id}")
//    public String showFormEdit(@PathVariable int id, Model model) {
//        model.addAttribute("blog", blogService.showBlogUpdate(id));
//        model.addAttribute("categorys", categoryService.getCategory());
//        return "edit";
//    }
//
//
//    @GetMapping("/detail/{id}")
//    public String showFormDetail(@PathVariable int id, Model model) {
//        model.addAttribute("blog", blogService.showBlogUpdate(id));
//        return "detail";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
//        if (blogService.delete(id)) {
//            redirectAttributes.addFlashAttribute("msg", "Xóa thành công. ");
//        } else {
//            redirectAttributes.addFlashAttribute("msg", "Không tìm thấy id. ");
//        }
//        return "redirect:/blog";
//    }
//
//
//    @PostMapping("/edit")
//    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
//        if (blogService.update(blog)) {
//            redirectAttributes.addFlashAttribute("msg", "Sửa thành công. ");
//        } else {
//            redirectAttributes.addFlashAttribute("msg", "Không tìm thấy id. ");
//        }
//        return "redirect:/blog";
//    }
//
//
//    @PostMapping("/create")
//    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
//        blogService.create(blog);
//        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công. ");
//        return "redirect:/blog";
//    }
//
//}
