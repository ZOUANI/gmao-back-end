package com.example.demo.service;

import com.example.demo.bean.TypeMagasin;
import com.example.demo.dao.TypeMagasinDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeMagasinService {
    @Autowired
    private TypeMagasinDao typeMagasinDao;

    public TypeMagasin findByCode(String code) {
        return typeMagasinDao.findByCode(code);
    }
}
