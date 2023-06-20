package com.example.bai_3.repository;

import com.example.bai_3.model.Email;
import org.springframework.stereotype.Repository;


@Repository
public class EmailRepository implements IEmailRepository {
    private static Email email;

    static {
        email=new Email("English", 25, false, "Thor King,Asgard");
    }

    @Override
    public Email display() {
        return email;
    }

    @Override
    public void update(Email email1) {
        email.setLanguage(email1.getLanguage());
        email.setPageSize(email1.getPageSize());
        email.setSpamsFilter(email1.isSpamsFilter());
        email.setSignature(email1.getSignature());
    }
}
