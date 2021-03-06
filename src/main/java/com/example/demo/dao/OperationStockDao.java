package com.example.demo.dao;

import com.example.demo.bean.OperationStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OperationStockDao extends JpaRepository<OperationStock,Long> {
    List<OperationStock> findByMagasinDestinationReference(String magasindestinationreference);
    List<OperationStock> findByMagasinSourceReference(String magasinsourcereference);
    List<OperationStock> findByMagasinDestinationReferenceAndMagasinSourceReference(String magasindestinationreference,String magasinsourcereference);
   // List<OperationStock> findByMaterialRef(String refMaterial);
    List<OperationStock> findByMagasinDestinationReferenceAndMagasinSourceReferenceAndMaterialReference(String magasindestinationreference,String magasinsourcereference,String refMaterial);
    List<OperationStock> findAll();
    List<OperationStock> findByMaterialReference(String refMaterial);
    Optional<OperationStock> findById(Long id);
    void deleteById(Long id);
}
