/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.dao;

import com.example.demo.bean.Equipe;
import com.example.demo.bean.MembreEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author mehdi
 */
@Repository
public interface MembreEquipeDao extends JpaRepository<MembreEquipe, Long> {

    public MembreEquipe findByCollaborateurFullname(String fullname);

    public List<MembreEquipe> findByEquipeRef(String ref);
    public MembreEquipe  findByCollaborateurCodeCollaborateur(String code);
    public int deleteByCollaborateurFullname(String fullname);

}
