package com.example.demo.dao;

import com.example.demo.bean.MateraialIntervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateraialInterventionDao extends JpaRepository<MateraialIntervention,Long> {
    MateraialIntervention findByMaterialReferenceAndInterventionCode(String reference,String code);
    int deleteByMaterialReferenceAndInterventionCode(String reference,String code);
}