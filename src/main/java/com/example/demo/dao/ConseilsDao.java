package com.example.demo.dao;

import java.util.List;

import com.example.demo.bean.Conseils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConseilsDao extends JpaRepository<Conseils, Long> {
    public List<Conseils> findByCollaborateurCodeCollaborateur(String code);

    // public List<Consigne> findByEquipeRef(String ref);
    // public List<Conseils> findByDateDeMessage(Date date);
    // public List<Consigne> findByEquipeRefAndCollaborateurCodeCollaborateur(String
    // ref, String code);
    public List<Conseils> findAll();

    public void deleteById(Long id);

    // public int deleteByDateDeMessage(Date date);
    int deleteByCollaborateurCodeCollaborateurAndMessageAndInterventionCode(String code, String message, String interv);

    List<Conseils> findByInterventionCode(String code);
}
