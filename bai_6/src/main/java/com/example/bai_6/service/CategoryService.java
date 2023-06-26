package com.example.bai_6.service;

import com.example.bai_6.model.Category;
import com.example.bai_6.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        categoryRepository.deleteById(id);
        return true;
    }

    @Override
    public Category showFormEdit(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public boolean edit(Category category) {
        categoryRepository.save(category);
        return false;
    }

    @Override
    public void create(Category category) {
        categoryRepository.save(category);
    }
}
