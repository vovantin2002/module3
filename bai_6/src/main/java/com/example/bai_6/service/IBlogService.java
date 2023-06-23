package com.example.bai_6.service;

import com.example.bai_6.model.Blog;

import java.awt.print.Pageable;
import java.util.List;

public interface IBlogService {
    List<Blog> display(Pageable pageable);

    void create(Blog blog);

    boolean delete(int id);

    boolean update(Blog blog);

    Blog showBlogUpdate(int id);

}
