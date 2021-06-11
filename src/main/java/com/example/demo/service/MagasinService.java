package com.example.demo.service;

import com.example.demo.bean.Stock;
import com.example.demo.bean.TypeMagasin;
import com.example.demo.dao.MagasinDao;
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
    @Autowired
    private TypeMagasinService typeMagasinService;
    @Autowired
    private StockService stockService;
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

    public int save(Magasin magasin){
        if(findByReference(magasin.getReference())!=null){
            return -2;
        }
        TypeMagasin typeMagasin=typeMagasinService.findByCode(magasin.getTypemagasin().getCode());
        magasin.setTypemagasin(typeMagasin);

        Magasin magasin1=new Magasin();
        magasin1.setTypemagasin(magasin.getTypemagasin());
        magasin1.setAdresse(magasin.getAdresse());
        magasin1.setReference(magasin.getReference());
        magasinDao.save(magasin1);
        for (Stock stock: magasin.getStocks() ) {
            stock.setMagasin(magasin);
            stockService.savestockage(stock);
        }
        magasin1.setStocks(magasin.getStocks());

        return 1;
    }
}
