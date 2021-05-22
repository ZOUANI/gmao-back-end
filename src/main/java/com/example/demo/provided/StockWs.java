package com.example.demo.provided;

import com.example.demo.service.StockService;
import com.example.demo.bean.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RestController
@RequestMapping("Gmao/Stockage")
public class StockWs {
    @Autowired
     StockService stockService;
    @GetMapping("/refMaterial/{refMaterial}")
    public List<Stock> findByMaterialReference(@PathVariable String refMaterial) {
        return stockService.findByMaterialReference(refMaterial);
    }
    @GetMapping("/reference/{reference}")
    public List<Stock> findByMagasinReference(@PathVariable String reference) {
        return stockService.findByMagasinReference(reference);
    }
    @GetMapping("/reference/{reference}/refMaterial/{refMaterial}")
    public Stock findByMagasinReferenceAndMaterialReference(@PathVariable String reference, @PathVariable String refMaterial) {
        return stockService.findByMagasinReferenceAndMaterialReference(reference, refMaterial);
    }
    @GetMapping("/")
    public List<Stock> findAll() {
        return stockService.findAll();
    }
    @DeleteMapping("/reference/{reference}")
    public int deleteByMagasinReference(@PathVariable String reference) {
        return stockService.deleteByMagasinReference(reference);
    }
    @DeleteMapping("/refMaterial/{ref}")
    public int deleteByMaterialReference(@PathVariable String ref) {
        return stockService.deleteByMaterialReference(ref);
    }

    @DeleteMapping("/refMaterial/{refMaterial}/reference/{reference}")
    public int deleteByMaterialReferenceAndMagasinReference(@PathVariable String refMaterial,@PathVariable String reference) {
        return stockService.deleteByMaterialReferenceAndMagasinReference(refMaterial, reference);
    }
    @PostMapping("/")
    public int savestockage(@RequestBody Stock stockage) {
        return stockService.savestockage(stockage);
    }
    @GetMapping("/download")
    public ResponseEntity<Resource> getFile() {
        String filename = "Stock.xlsx";
        InputStreamResource file = new InputStreamResource(stockService.load());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }
}
