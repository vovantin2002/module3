package com.example.bai_3.service;

import com.example.bai_3.model.Email;
import com.example.bai_3.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmailService implements IEmailService {
    @Autowired
    private IEmailRepository emailRepository;

    @Override
    public Email display() {
        return emailRepository.display();
    }

    @Override
    public void update(Email email) {
        emailRepository.update(email);
    }
}
