package com.example.demo.dao;

import com.example.demo.bean.Conseils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ConseilsDao extends JpaRepository<Conseils,Long> {
    public List<Conseils> findByCollaborateurCodeCollaborateur(String code);
//    public List<Consigne> findByEquipeRef(String ref);
//    public  List<Conseils> findByDateDeMessage(Date date);
//    public  List<Consigne> findByEquipeRefAndCollaborateurCodeCollaborateur(String ref, String code);
    public List<Conseils> findAll();
    public void deleteById(Long id);
//    public int deleteByDateDeMessage(Date date);
    public int deleteByCollaborateurCodeCollaborateur(String code);
    List<Conseils> findByInterventionCode(String code);
}
