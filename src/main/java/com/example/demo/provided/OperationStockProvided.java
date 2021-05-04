package com.example.demo.provided;

import com.example.demo.service.OperationStockService;
import com.example.demo.bean.OperationStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Stock/OperationStockBean")
public class OperationStockProvided {
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
    public List<OperationStock> findByMagasinDestinationReferenceAndMagasinSourceReference(@PathVariable String magasindestinationreference,@PathVariable String magasinsourcereference) {
        return operationStockService.findByMagasinDestinationReferenceAndMagasinSourceReference(magasindestinationreference, magasinsourcereference);
    }
    @GetMapping("/refMaterial/{refMaterial}")
    public List<OperationStock> findByMaterialRef(@PathVariable String refMaterial) {
        return operationStockService.findByMaterialRef(refMaterial);
    }
    @GetMapping("/magasindestinationreference/{magasindestinationreference}/magasinsourcereference/{magasinsourcereference}/refMaterial/{refMaterial}")
    public List<OperationStock> findByMagasinDestinationReferenceAndMagasinSourceReferenceAndMaterialRef(@PathVariable String magasindestinationreference,@PathVariable String magasinsourcereference,@PathVariable String refMaterial) {
        return operationStockService.findByMagasinDestinationReferenceAndMagasinSourceReferenceAndMaterialRef(magasindestinationreference, magasinsourcereference, refMaterial);
    }
    @GetMapping("/")
    public List<OperationStock> findAll() {
        return operationStockService.findAll();
    }
    @DeleteMapping("/id/{id}")
    public void deleteById(Long id) {
        operationStockService.deleteById(id);
    }
}
