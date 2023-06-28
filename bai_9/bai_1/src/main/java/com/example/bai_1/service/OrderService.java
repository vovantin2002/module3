package com.example.bai_1.service;

import com.example.bai_1.model.Oder;
import com.example.bai_1.repository.IOderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {
    @Autowired
   private IOderRepository oderRepository;

    @Override
    public void create(Oder oder) {
        oderRepository.save(oder);
    }

    @Override
    public Oder findById(String code) {
        return oderRepository.findByCode(code);
    }

    @Override
    public void delete(Oder oder) {
        oderRepository.delete(oder);
    }
}
