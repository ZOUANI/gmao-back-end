package com.example.demo.dao;

import com.example.demo.bean.DemandeConge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DemandeCongeDao extends JpaRepository<DemandeConge,Long> {
    Optional<DemandeConge> findById(Long id);
    public List<DemandeConge> findByAction(String action);
    DemandeConge findByCode(String code);
    public List<DemandeConge> findByCollaborateurCodeCollaborateur(String collaborateur);
    int deleteByCode(String code);
}

