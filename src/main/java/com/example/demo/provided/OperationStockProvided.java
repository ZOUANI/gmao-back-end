package com.example.demo.provided;

import java.util.List;

import com.example.demo.bean.OperationStock;
import com.example.demo.service.OperationStockService;
import com.example.demo.vo.OperationStockVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Stock/OperationStockBean")
public class OperationStockProvided {
    @PostMapping("/criteria")
    public List<OperationStock> findByCriteria(@RequestBody OperationStockVo operationStockVo) {
        return operationStockService.findByCriteria(operationStockVo);
    }

    @Autowired
    OperationStockService operationStockService;

    @GetMapping("/magasindestinationreference/{magasindestinationreference}")
    public List<OperationStock> findByMagasinDestinationReference(@PathVariable String magasindestinationreference) {
        return operationStockService.findByMagasinDestinationReference(magasindestinationreference);
    }

    @GetMapping("/magasinsourcereference/{magasinsourcereference}")
    public List<OperationStock> findByMagasinSourceReference(@PathVariable String magasinsourcereference) {
        return operationStockService.findByMagasinSourceReference(magasinsourcereference);
    }

    @GetMapping("/magasindestinationreference/{magasindestinationreference}/magasinsourcereference/{magasinsourcereference}")
    public List<OperationStock> findByMagasinDestinationReferenceAndMagasinSourceReference(
            @PathVariable String magasindestinationreference, @PathVariable String magasinsourcereference) {
        return operationStockService.findByMagasinDestinationReferenceAndMagasinSourceReference(
                magasindestinationreference, magasinsourcereference);
    }

    @GetMapping("/refMaterial/{refMaterial}")
    public List<OperationStock> findByMaterialReference(@PathVariable String refMaterial) {
        return operationStockService.findByMaterialReference(refMaterial);
    }

    @GetMapping("/magasindestinationreference/{magasindestinationreference}/magasinsourcereference/{magasinsourcereference}/refMaterial/{refMaterial}")
    public List<OperationStock> findByMagasinDestinationReferenceAndMagasinSourceReferenceAndMaterialReference(
            @PathVariable String magasindestinationreference, @PathVariable String magasinsourcereference,
            @PathVariable String refMaterial) {
        return operationStockService.findByMagasinDestinationReferenceAndMagasinSourceReferenceAndMaterialReference(
                magasindestinationreference, magasinsourcereference, refMaterial);
    }

    @GetMapping("/")
    public List<OperationStock> findAll() {
        return operationStockService.findAll();
    }

    @PostMapping("/")
    public int transferer(@RequestBody OperationStock operationStock) {
        return operationStockService.transferer(operationStock);
    }

    @PutMapping("/update/{id}")
    public int update(@PathVariable Long id, @RequestBody OperationStock operationStock) {
        return operationStockService.update(id, operationStock);
    }

    @DeleteMapping("/idde/{id}")
    public void deleteById(@PathVariable Long id) {
        operationStockService.deleteById(id);
    }
}
