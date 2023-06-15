package com.example.springgreeting.service;

import org.springframework.stereotype.Service;

@Service
public class ChangeMoneyService implements IChangeMoneyService{
    @Override
    public Double changeMoney(Double money) {
        return money*26000;
    }
}
