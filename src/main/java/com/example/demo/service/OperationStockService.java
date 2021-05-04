package com.example.demo.service;

import com.example.demo.bean.Magasin;
import com.example.demo.bean.OperationStock;
import com.example.demo.bean.Material;
import com.example.demo.bean.Stock;
import com.example.demo.dao.OperationStockDao;
import com.example.demo.dao.MaterialDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class OperationStockService {
    @Autowired
    private OperationStockDao operationStockDao;
    @Autowired
    private StockService stokage;
    @Autowired
    private MagasinService magasinService;
    @Autowired
    private MaterialDao materialDao;
    public List<OperationStock> findByMagasinDestinationReference(String magasindestinationreference) {
        return operationStockDao.findByMagasinDestinationReference(magasindestinationreference);
    }

    public List<OperationStock> findByMagasinSourceReference(String magasinsourcereference) {
        return operationStockDao.findByMagasinSourceReference(magasinsourcereference);
    }

    public List<OperationStock> findByMagasinDestinationReferenceAndMagasinSourceReference(String magasindestinationreference, String magasinsourcereference) {
        return operationStockDao.findByMagasinDestinationReferenceAndMagasinSourceReference(magasindestinationreference, magasinsourcereference);
    }

    public List<OperationStock> findByMaterialRef(String refMaterial) {
        return operationStockDao.findByMaterialRef(refMaterial);
    }

    public List<OperationStock> findByMagasinDestinationReferenceAndMagasinSourceReferenceAndMaterialRef(String magasindestinationreference, String magasinsourcereference, String refMaterial) {
        return operationStockDao.findByMagasinDestinationReferenceAndMagasinSourceReferenceAndMaterialRef(magasindestinationreference, magasinsourcereference, refMaterial);
    }

    public List<OperationStock> findAll() {
        return operationStockDao.findAll();
    }
    @Transactional
    public void deleteById(Long id) {
        operationStockDao.deleteById(id);
    }

    public int transporterleStock(String refmagasinSource, String refmagasinDestination, double qte, String refmaterial){
        Stock  magasinSource=stokage.findByMagasinReferenceAndMaterialRef(refmagasinSource,refmaterial);
        Stock magasinDestination=stokage.findByMagasinReferenceAndMaterialRef(refmagasinDestination,refmaterial);
        Magasin magasinsource=magasinService.findByReference(refmagasinSource);
        Magasin magasindestination=magasinService.findByReference(refmagasinDestination);
        Material produit=materialDao.findByReference(refmaterial);
        double produitqtesrc=magasinSource.getQte();
        double produitqtedes =magasinDestination.getQte();
        int materialqtesrc = 0;
        if(magasinDestination!=null && magasinSource!=null && materialqtesrc>qte){
            magasinSource.setQte(materialqtesrc-qte);
            magasinDestination.setQte(materialqtesrc+qte);
            OperationStock transport=new OperationStock();
            transport.setQte(qte);
            transport.setId(Long.valueOf("transport "+qte+" de "+refmaterial+" de magasin "+refmagasinSource+" a le magasin "+refmagasinDestination));
            Material material = new Material();
            transport.setMaterial(material);
            transport.setMagasinDestination(magasindestination);
            transport.setMagasinSource(magasinsource);
            operationStockDao.save(transport);
            return 1;
        }
        else return -2;
    }
    public int transferer(String refSource, String refDestination, String refMaterial, double qte) {
        Magasin magasinSource = magasinService.findByReference(refSource);
        Magasin magasinDestination = magasinService.findByReference(refDestination);
        Material material = materialDao.findByReference(refMaterial);

        if (material == null || magasinSource == null || magasinDestination == null)
            return -1;

        Stock stockSource = stokage.findByMagasinReferenceAndMaterialRef(refSource, refMaterial);

        if (stockSource == null) {
            return -2;
        } else {
            Stock stockDestination = stokage.findByMagasinReferenceAndMaterialRef(refSource, refMaterial);
            if (stockDestination == null) {

                Stock myStock = new Stock();
                myStock.setMagasin(magasinDestination);
                myStock.setMaterial(material);
                myStock.setQte(qte);
                stokage.savestockage(myStock);
                return 1;
            } else {
                stockDestination.setQte(stockDestination.getQte() + qte);
                stokage.savestockage(stockDestination);
                return 2;
            }

        }
    }

}
