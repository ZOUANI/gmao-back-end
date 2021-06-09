package com.example.demo.dao;

import com.example.demo.bean.ChefEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChefEquipeDao extends JpaRepository<ChefEquipe,Long> {
    ChefEquipe findByCode(String code);
    Optional<ChefEquipe> findById(Long id);
    int deleteByCode(String code);
    ChefEquipe findByLogin(String login);
}
