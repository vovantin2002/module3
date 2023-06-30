package com.example.bai_6.service;

import com.example.bai_6.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IBlogService {
    Page<Blog> display(Pageable pageable);
    List<Blog> displayList();
    List<Blog> findBlogByCategoryId(int categoryId);

    void create(Blog blog);

    boolean delete(int id);

    boolean update(Blog blog);

    Blog showBlogUpdate(int id);

    Page<Blog> findAllByTitle(Pageable pageable, String title);

}
