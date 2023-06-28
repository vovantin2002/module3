package com.example.bai_1.service;

import com.example.bai_1.model.Oder;

public interface IOrderService {
    void create(Oder oder);

    Oder findById(String code);

    void delete(Oder oder);
}
