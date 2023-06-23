package com.example.bai_6.repository;

import com.example.bai_6.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAll(Pageable pageable);
}
