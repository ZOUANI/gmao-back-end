package com.example.demo.dao;

import com.example.demo.bean.TypeMagasin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeMagasinDao extends JpaRepository<TypeMagasin,Long> {
    TypeMagasin findByCode(String code);
}
