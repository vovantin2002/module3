package com.example.bai_6.service;

import com.example.bai_6.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getCategory();
    boolean delete(int id);
    Category showFormEdit(int id);
    boolean edit(Category category);
    void create(Category category);
}
