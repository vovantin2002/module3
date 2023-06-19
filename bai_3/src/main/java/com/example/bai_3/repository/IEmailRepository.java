package com.example.bai_3.repository;

import com.example.bai_3.model.Email;


public interface IEmailRepository {
    Email display();

    void update(Email email);
}
