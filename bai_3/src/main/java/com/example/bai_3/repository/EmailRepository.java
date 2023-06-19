package com.example.bai_3.repository;

import com.example.bai_3.model.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {
    private static List<Email> emailList = new ArrayList<>();

    static {
        emailList.add(new Email("English", 25, false, "Thor King,Asgard"));
    }

    @Override
    public Email display() {
        Email email = null;
        for (int i = 0; i < emailList.size(); i++) {
            email = emailList.get(i);
        }
        return email;
    }

    @Override
    public void update(Email email) {
        for (int i = 0; i < emailList.size(); i++) {
            emailList.set(i, email);
        }
    }
}
