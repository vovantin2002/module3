package com.example.bai_1.service;

import com.example.bai_1.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> display();

    Book detail(int id);

    void edit(Book book);

    void pay(Book book);
}
