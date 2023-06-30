package com.example.bai_6.controller;

import com.example.bai_6.model.Blog;
import com.example.bai_6.model.Category;
import com.example.bai_6.service.IBlogService;
import com.example.bai_6.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping()
    public List<Blog> display() {
        return this.blogService.displayList();
    }

    @GetMapping("/category")
    public List<Category> displayCategory() {
        return this.categoryService.getCategory();
    }

    @GetMapping("/detail/{id}")
    public Blog showFormDetail(@PathVariable int id) {
        if (blogService.showBlogUpdate(id) == null) {
            throw new RuntimeException("id khong ton tai");
        }
        return blogService.showBlogUpdate(id);
    }

    @GetMapping("/search/{id}")
    public List<Blog> getPostsByCategoryId(@PathVariable int id) {
        if (blogService.findBlogByCategoryId(id) == null) {
            throw new RuntimeException("id khong ton tai");
        }
        return blogService.findBlogByCategoryId(id);
    }
}
