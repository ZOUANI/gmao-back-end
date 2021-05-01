package com.example.demo.service;

import com.example.demo.dao.StockDao;
import com.example.demo.Util.SimpleDb2ExcelExporter;
import com.example.demo.bean.Magasin;
import com.example.demo.bean.Material;
import com.example.demo.bean.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
public class StockService {
    public List<Stock> findByMaterialReference(String refMaterial) {
        return stockDao.findByMaterialReference(refMaterial);
    }

    public List<Stock> findByMagasinReference(String reference) {
        return stockDao.findByMagasinReference(reference);
    }

    public Stock findByMagasinReferenceAndMaterialReference(String reference, String refMaterial) {
        return stockDao.findByMagasinReferenceAndMaterialReference(reference, refMaterial);
    }

    public List<Stock> findAll() {
        return stockDao.findAll();
    }
    @Transactional
    public int deleteByMaterialReference(String ref) {
        return stockDao.deleteByMaterialReference(ref);
    }
    @Transactional
    public int deleteByMagasinReference(String reference) {
        return stockDao.deleteByMagasinReference(reference);
    }
    @Transactional
    public int deleteByMaterialReferenceAndMagasinReference(String refMaterial, String reference) {
        return stockDao.deleteByMaterialReferenceAndMagasinReference(refMaterial, reference);
    }
    public int savestockage(Stock stockage) {
        Material material = materialService.findByReference(stockage.getMaterial().getReference());
        Magasin magasin = magasinService.findByReference(stockage.getMagasin().getReference());
        Stock stockBean = findByMagasinReferenceAndMaterialReference(stockage.getMagasin().getReference(), stockage.getMaterial().getReference());
        if(magasin==null) return -2;
        if(material==null) return -2;

        if(stockBean==null){
            Stock myStockBean= new Stock();
            myStockBean.setMaterial(material);
            myStockBean.setMagasin(magasin);
            myStockBean.setQte(stockage.getQte());
            stockDao.save(myStockBean);
            return 1;
        }else{
            stockBean.setQte(stockBean.getQte()+stockage.getQte());
            stockDao.save(stockBean);
            return 2;
        }
    }
    public ByteArrayInputStream load() {
        List<Stock> stocks = findAll();
        ByteArrayInputStream in = SimpleDb2ExcelExporter.StocksToExcel(stocks);
        return in;
    }
    @Autowired
    private StockDao stockDao;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private MagasinService magasinService;
}
