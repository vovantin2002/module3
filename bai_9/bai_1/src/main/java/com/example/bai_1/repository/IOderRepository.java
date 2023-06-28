package com.example.bai_1.repository;

import com.example.bai_1.model.Oder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOderRepository extends JpaRepository<Oder, Integer> {
    Oder findByCode(String code);
}
