package com.example.demo.dao;

import com.example.demo.bean.EtatTache;
import com.example.demo.bean.TacheIntervention;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TacheInterventionDao extends JpaRepository<TacheIntervention,Long> {
    TacheIntervention findByCode(String code);
    TacheIntervention findByLibelle(String libelle);
    TacheIntervention findByDescription(String description);

    List<TacheIntervention> findByEtatTacheDescription(String description);
    List<TacheIntervention> deleteByEtatTacheDescription(String description);

    List<TacheIntervention> findByEtatTacheLibelle(String libelle);
    List<TacheIntervention> deleteByEtatTacheLibelle(String libelle);

    List<TacheIntervention> findByEtatTacheCode(String code);
    List<TacheIntervention> deleteByEtatTacheCode(String code);


}
