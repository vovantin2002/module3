package com.example.bai_6.controller;

import com.example.bai_6.model.Blog;
import com.example.bai_6.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String display(Model model) {
        model.addAttribute("blogList", blogService.display());
        return "list";
    }

    @GetMapping("/showFormCreate")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.showBlogUpdate(id));
        return "edit";
    }

    @GetMapping("/detail/{id}")
    public String showFormDetail(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.showBlogUpdate(id));
        return "detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (blogService.delete(id)) {
            redirectAttributes.addFlashAttribute("msg", "Xóa thành công. ");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Không tìm thấy id. ");
        }
        return "redirect:/";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        if (blogService.update(blog)) {
            redirectAttributes.addFlashAttribute("msg", "Sửa thành công. ");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Không tìm thấy id. ");
        }
        return "redirect:/";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.create(blog);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công. ");
        return "redirect:/";
    }
}
