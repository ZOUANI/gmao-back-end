package com.example.demo.dao;

import com.example.demo.bean.EtatTache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatTacheDao extends JpaRepository<EtatTache,Long> {
    EtatTache findByCode(String code);
    EtatTache findByLibelle(String libelle);
    EtatTache findByDescription(String description);

    int deleteByCode(String code);


}
