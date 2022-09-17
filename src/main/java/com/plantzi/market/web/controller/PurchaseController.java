package com.plantzi.market.web.controller;

import com.plantzi.market.domain.dto.PurchaseDto;
import com.plantzi.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/")
    public ResponseEntity<List<PurchaseDto>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/client/{id}")
    public ResponseEntity<List<PurchaseDto>> getByCategory(@PathVariable("id") String clientId) {
        return purchaseService.getByClient(clientId)
                .map(shopping -> new ResponseEntity<>(shopping, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<PurchaseDto> save(@RequestBody PurchaseDto shopping) {
        return new ResponseEntity<>(purchaseService.save(shopping), HttpStatus.CREATED);
    }
}
