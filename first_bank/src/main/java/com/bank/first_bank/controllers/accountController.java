package com.bank.first_bank.controllers;

import com.bank.first_bank.dto.AccountDto;
import com.bank.first_bank.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class accountController {
    private final AccountService service;

    @PostMapping("/")
    public ResponseEntity<Long> save(@RequestBody AccountDto accountDto){

        return ResponseEntity.ok(service.save(accountDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<AccountDto>> findByAll(){

        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{account-id}")
    public ResponseEntity<AccountDto> findById(
            @PathVariable("account-id") Long accountId){
        return ResponseEntity.ok(service.findById(accountId));
    }

    @DeleteMapping("/{account-id}")
    public ResponseEntity<Void> delete(
            @PathVariable("account-id") Long accountId){
        service.delete(accountId);
        return ResponseEntity.accepted().build();
    }

}
