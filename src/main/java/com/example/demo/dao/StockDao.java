package com.example.demo.dao;
import com.example.demo.bean.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StockDao extends JpaRepository<Stock,Long> {
    List<Stock> findByMaterialReference(String refMaterial);
    List<Stock> findByMagasinReference(String reference);
    Stock findByMagasinReferenceAndMaterialReference(String  reference, String refMaterial);
    List <Stock> findAll();
    int deleteByMaterialReference(String ref);
    int deleteByMagasinReference(String reference);
    int deleteByMaterialReferenceAndMagasinReference(String refMaterial,String reference);
}
