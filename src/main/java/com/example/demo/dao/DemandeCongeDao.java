package com.example.demo.dao;

import com.example.demo.bean.DemandeConge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DemandeCongeDao extends JpaRepository<DemandeConge,Long> {
    Optional<DemandeConge> findById(Long id);
    List<DemandeConge> findByEtatDemandeCongeCode(String code);
    DemandeConge findByCode(String code);
    int deleteByCode(String code);
}

