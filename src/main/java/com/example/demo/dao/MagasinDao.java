package com.example.demo.dao;

import com.example.demo.bean.Magasin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MagasinDao extends JpaRepository<Magasin,Long> {
    List<Magasin> findByAdresse(String adresse);
    Magasin findByReference(String Ref);
    @Query(value = "select a from Magasin a where a.adresse LIKE  '%x%' ")
    List<Magasin> chercherMagasinparAdresse(@Param("x") String motcle);
    Magasin findByTypemagasinCode(String Code);
    List<Magasin> findAll();
    int deleteByReference(String ref);
}
