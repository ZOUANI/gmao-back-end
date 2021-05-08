package com.example.demo.dao;

import com.example.demo.bean.Consigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ConseilsDao extends JpaRepository<Consigne,Long> {
    public List<Consigne> findByCollaborateurCodeCollaborateur(String code);
//    public List<Consigne> findByEquipeRef(String ref);
    public  List<Consigne> findByDateDeMessage(Date date);
//    public  List<Consigne> findByEquipeRefAndCollaborateurCodeCollaborateur(String ref, String code);
    public List<Consigne> findAll();
    public void deleteById(Long id);
    public int deleteByDateDeMessage(Date date);
    public int deleteByCollaborateurCodeCollaborateur(String code);
}
