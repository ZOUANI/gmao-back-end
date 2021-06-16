package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.example.demo.bean.Magasin;
import com.example.demo.bean.Material;
import com.example.demo.bean.OperationStock;
import com.example.demo.bean.Stock;
import com.example.demo.dao.OperationStockDao;
import com.example.demo.service.util.StringUtil;
import com.example.demo.vo.OperationStockVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationStockService {

    @Autowired
    private OperationStockDao operationStockDao;
    @Autowired
    private StockService stokage;
    @Autowired
    private MagasinService magasinService;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private EntityManager entityManager;

    public int update(Long id, OperationStock operationStock) {
        Optional<OperationStock> operationStock1 = findById(id);
        if (operationStock1 != null) {
            Material material = materialService.findByReference(operationStock.getMaterial().getReference());
            operationStock1.get().setMaterial(material);
            operationStock1.get().setQte(operationStock.getQte());
            operationStock1.get().setMagasinDestination(
                    magasinService.findByReference(operationStock.getMagasinDestination().getReference()));
            operationStock1.get()
                    .setMagasinSource(magasinService.findByReference(operationStock.getMagasinSource().getReference()));
            operationStockDao.save(operationStock1.get());
            return 1;
        } else
            return -2;
    }

    public Optional<OperationStock> findById(Long id) {
        return operationStockDao.findById(id);
    }

    public List<OperationStock> findByCriteria(OperationStockVo operationStockVo) {
        String query = "SELECT o FROM OperationStock o WHERE 1=1 ";
        if (StringUtil.isNotEmpty(operationStockVo.getReferences()))
            query += " AND o.references ='" + operationStockVo.getReferences() + "'";

        if (StringUtil.isNotEmpty(operationStockVo.getQteMin()))
            query += " AND o.Qte >= '" + operationStockVo.getQteMin() + "'";

        if (StringUtil.isNotEmpty(operationStockVo.getQteMax()))
            query += " AND o.Qte <= '" + operationStockVo.getQteMax() + "'";

        return entityManager.createQuery(query).getResultList();
    }

    public List<OperationStock> findByMagasinDestinationReference(String magasindestinationreference) {
        return operationStockDao.findByMagasinDestinationReference(magasindestinationreference);
    }

    public List<OperationStock> findByMagasinSourceReference(String magasinsourcereference) {
        return operationStockDao.findByMagasinSourceReference(magasinsourcereference);
    }

    public List<OperationStock> findByMagasinDestinationReferenceAndMagasinSourceReference(
            String magasindestinationreference, String magasinsourcereference) {
        return operationStockDao.findByMagasinDestinationReferenceAndMagasinSourceReference(magasindestinationreference,
                magasinsourcereference);
    }

    public List<OperationStock> findByMaterialReference(String refMaterial) {
        return operationStockDao.findByMaterialReference(refMaterial);
    }

    public List<OperationStock> findByMagasinDestinationReferenceAndMagasinSourceReferenceAndMaterialReference(
            String magasindestinationreference, String magasinsourcereference, String refMaterial) {
        return operationStockDao.findByMagasinDestinationReferenceAndMagasinSourceReferenceAndMaterialReference(
                magasindestinationreference, magasinsourcereference, refMaterial);
    }

    public List<OperationStock> findAll() {
        return operationStockDao.findAll();
    }

    @Transactional
    public void deleteById(Long id) {
        operationStockDao.deleteById(id);
    }

    public int transferer(OperationStock operationStock) {
        Magasin magasinSource = magasinService.findByReference(operationStock.getMagasinSource().getReference());
        Magasin magasinDestination = magasinService
                .findByReference(operationStock.getMagasinDestination().getReference());
        Material material = materialService.findByReference(operationStock.getMaterial().getReference());

        if (material == null || magasinSource == null || magasinDestination == null)
            return -1;

        Stock stockSource = stokage.findByMagasinReferenceAndMaterialReference(
                operationStock.getMagasinSource().getReference(), operationStock.getMaterial().getReference());

        if (stockSource == null) {
            return -2;
        }
        if (stockSource.getQte() < operationStock.getQte()) {
            return -3;
        } else {
            Stock stockDestination = stokage.findByMagasinReferenceAndMaterialReference(
                    operationStock.getMagasinDestination().getReference(), operationStock.getMaterial().getReference());
            if (stockDestination == null) {
                Stock myStock = new Stock();
                myStock.setMagasin(magasinDestination);
                myStock.setMaterial(material);
                myStock.setQte(operationStock.getQte());
                stokage.savestockage(myStock);
                return 1;
            } else {
                stockDestination.setQte(stockDestination.getQte() + operationStock.getQte());
                stockSource.setQte(stockSource.getQte() - operationStock.getQte());
                OperationStock transport = new OperationStock();
                transport.setQte(operationStock.getQte());
                transport.setMaterial(material);
                transport.setMagasinDestination(magasinDestination);
                transport.setMagasinSource(magasinSource);
                operationStockDao.save(transport);
                return 2;
            }

        }
    }
}
