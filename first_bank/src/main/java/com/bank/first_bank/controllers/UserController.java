package com.bank.first_bank.controllers;

import com.bank.first_bank.dto.UserDto;
import com.bank.first_bank.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/")
    public ResponseEntity<Long> save(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(service.save(userDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<UserDto> findById(@PathVariable("user-id") Long userId) {
        return ResponseEntity.ok(service.findById(userId));
    }

    @PatchMapping("/validate/{user-id}")
    public ResponseEntity<Long> validateAccount(@PathVariable("user-id") Long userId) {

        return ResponseEntity.ok(service.validateAccount(userId));
    }

    @PatchMapping("/invalidate/{user-id}")
    public ResponseEntity<Long> invalidateAccount(@PathVariable("user-id") Long userId) {

        return ResponseEntity.ok(service.invalidateAccount(userId));
    }

    @DeleteMapping("/{user-id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("user-id") Long userId) {

        service.delete(userId);

        return ResponseEntity.accepted().build();
    }

}
