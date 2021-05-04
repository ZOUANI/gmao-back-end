package com.example.demo.dao;

import com.example.demo.bean.EtatIntervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtatInterventionDao extends JpaRepository<EtatIntervention,Long> {
    EtatIntervention findByCode(String code);
    List<EtatIntervention> findByCouleurIntervention(String couleurIntervention);
    int deleteByCode(String code);
}
