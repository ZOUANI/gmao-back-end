package com.example.demo.dao;

import com.example.demo.bean.Collaborateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaborateurDao extends JpaRepository<Collaborateur, Long> {

 public Collaborateur findByFullname(String fullname);

 public Collaborateur findByCodeCollaborateur(String codeCollaborateur);

 public int deleteByCodeCollaborateur(String codeCollaborateur);

}
