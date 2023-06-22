package com.example.bai_6.service;

import com.example.bai_6.model.Blog;
import com.example.bai_6.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> display() {
        return blogRepository.findAll();
    }

    @Override
    public void create(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public boolean delete(int id) {
        blogRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean update(Blog blog) {
        blogRepository.save(blog);
        return true;
    }

    @Override
    public Blog showBlogUpdate(int id) {
        return blogRepository.findById(id).get();
    }
}
