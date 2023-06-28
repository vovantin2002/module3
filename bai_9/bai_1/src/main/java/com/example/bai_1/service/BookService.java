package com.example.bai_1.service;

import com.example.bai_1.model.Book;
import com.example.bai_1.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> display() {
        return bookRepository.findAll();
    }

    @Override
    public Book detail(int id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void edit(Book book) {
        if (book.getQuantity() == 0) {
            throw new RuntimeException("so luong sach da het. ");
        } else {
            book.setQuantity(book.getQuantity() - 1);
        }
        bookRepository.save(book);
    }

    @Override
    public void pay(Book book) {
        bookRepository.save(book);
    }

}