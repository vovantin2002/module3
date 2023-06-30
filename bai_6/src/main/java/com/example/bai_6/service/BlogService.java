package com.example.bai_6.service;

import com.example.bai_6.model.Blog;
import com.example.bai_6.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> display(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> displayList() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> findBlogByCategoryId(int categoryId) {
        List<Blog>blogs=new ArrayList<>();
        for (int i = 0; i <displayList().size() ; i++) {
            if (categoryId==displayList().get(i).getCategory().getId()){
                blogs.add(blogRepository.findById(categoryId).get());
            }
        }
        return blogs;
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

    @Override
    public Page<Blog> findAllByTitle(Pageable pageable, String title) {
        return blogRepository.findAllByTitle(pageable, title);
    }


}
