package com.example.bai_6.controller;

import com.example.bai_6.model.Blog;
import com.example.bai_6.model.Category;
import com.example.bai_6.service.IBlogService;
import com.example.bai_6.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<Blog>> display() {
        return new ResponseEntity<>(blogService.displayList(), HttpStatus.OK);
    }

    @PostMapping("/search/{id}")
    public ResponseEntity<List<Blog>> searchArticles(@PathVariable int id, Model model) {
        List<Blog> blogList = blogService.findBlogByCategoryId(id);
        if (blogList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            model.addAttribute("blogList", blogList);
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> displayCategory() {
        return new ResponseEntity<>(categoryService.getCategory(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> showFormDetail(@PathVariable int id) {
        Blog blog = blogService.showBlogUpdate(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<List<Blog>> getPostsByCategoryId(@PathVariable int id) {
        List<Blog> blogList = blogService.findBlogByCategoryId(id);
        if (blogList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
    }
}
