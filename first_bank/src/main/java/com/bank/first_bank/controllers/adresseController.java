package com.bank.first_bank.controllers;

import com.bank.first_bank.dto.AdresseDto;
import com.bank.first_bank.services.AdresseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adresses")
@RequiredArgsConstructor
public class adresseController {

    private final AdresseService service;


    @PostMapping("/")
    public ResponseEntity<Long> save(@RequestBody AdresseDto adresseDto) {
        return ResponseEntity.ok(service.save(adresseDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<AdresseDto>> findAll() {

        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{adresse-id}")
    public ResponseEntity<AdresseDto> findById(@PathVariable("adresse-id")  Long adresseId){
        return ResponseEntity.ok(service.findById(adresseId));
    }

    @DeleteMapping("/{adresse-id}")
    public ResponseEntity<Void> deleteById(@PathVariable("adresse-id")  Long adresseId){
        service.delete(adresseId);
        return ResponseEntity.accepted().build();
    }
}
