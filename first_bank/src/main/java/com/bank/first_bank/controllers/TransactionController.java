package com.bank.first_bank.controllers;

import com.bank.first_bank.dto.TransactionDto;
import com.bank.first_bank.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @PostMapping("/")
    public ResponseEntity<Long> save(
            @RequestBody TransactionDto transactionDto){

        return ResponseEntity.ok(service.save(transactionDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<TransactionDto>> findByAll(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/users/{user-id}")
    public ResponseEntity<List<TransactionDto>> findByAllBuUserId(@PathVariable("user-id") Long userId){
        return ResponseEntity.ok(service.findAllByUserId(userId));
    }

    @GetMapping("/{transaction-id}")
    public ResponseEntity<TransactionDto> findById(@PathVariable("transaction-id") Long transactionDto){
        return ResponseEntity.ok(service.findById(transactionDto));
    }

    @DeleteMapping("/{transaction-id}")
    public ResponseEntity<Void> delete(@PathVariable("transaction-id") Long transactionDto){
        service.delete(transactionDto);
        return ResponseEntity.accepted().build();
    }
}
