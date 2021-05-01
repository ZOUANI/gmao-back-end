package com.example.demo.Service;

import com.example.demo.Dao.MagasinDao;
import com.example.demo.bean.Magasin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MagasinService {
    @Autowired
    private MagasinDao magasinDao;

    public List<Magasin> findByAdresse(String adresse) {
        return magasinDao.findByAdresse(adresse);
    }

    public Magasin findByReference(String Ref) {
        return magasinDao.findByReference(Ref);
    }


    public List<Magasin> chercherMagasinparAdresse(String motcle) {
        return magasinDao.chercherMagasinparAdresse(motcle);
    }

    public Magasin findByTypeMagasinCode(String Code) {
        return magasinDao.findByTypemagasinCode(Code);
    }

    public List<Magasin> findAll() {
        return magasinDao.findAll();
    }
    @Transactional
    public int deleteByReference(String ref) {
        return magasinDao.deleteByReference(ref);
    }
}
