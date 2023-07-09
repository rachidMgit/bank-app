package com.bank.first_bank.controllers;
import com.bank.first_bank.dto.ContactDto;
import com.bank.first_bank.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService service;

    @PostMapping("/")
    public ResponseEntity<Long> save(@RequestBody ContactDto contactDto){

        return ResponseEntity.ok(service.save(contactDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<ContactDto>> findByAll(Long contactDto){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/users/{user-id}")
    public ResponseEntity<List<ContactDto>> findByAllBuUserId(@PathVariable("user-id") Long userId){
        return ResponseEntity.ok(service.findAllByUserId(userId));
    }

    @GetMapping("/{contact-id}")
    public ResponseEntity<ContactDto> findById(@PathVariable("contact-id") Long contactDto){
        return ResponseEntity.ok(service.findById(contactDto));
    }

    @DeleteMapping("/{contact-id}")
    public ResponseEntity<Void> delete(@PathVariable("contact-id") Long contactDto){
        service.delete(contactDto);
        return ResponseEntity.accepted().build();
    }
}
