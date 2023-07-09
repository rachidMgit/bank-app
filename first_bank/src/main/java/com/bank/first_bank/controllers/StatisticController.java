package com.bank.first_bank.controllers;

import com.bank.first_bank.dto.TransactionSumDetails;
import com.bank.first_bank.services.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticController {
    private final StatisticsService service;

    @GetMapping("/sum-by-date/{user-id}")
    public ResponseEntity<List<TransactionSumDetails>> findSumTractionsByDate(
            @PathVariable("user-id") Long userId,
            @RequestParam("start-date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam("end-date")  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate
    ){
        return ResponseEntity.ok(service.findSumTractionsByDate(startDate, endDate, userId));
    }


@GetMapping("/account-balance/{user-id}")
    public ResponseEntity<BigDecimal> getAccountBalance(@PathVariable("user-id") Long userId) {
        return ResponseEntity.ok(service.getAccountBalance(userId));

    }


    @GetMapping("/highest-transfert/{user-id}")
    public ResponseEntity<BigDecimal> highestTransfert(@PathVariable("user-id") Long userId) {
        return ResponseEntity.ok(service.highestTransfert(userId));

    }


    @GetMapping("/highest-deposit/{user-id}")
    public ResponseEntity<BigDecimal> highestDeposit(@PathVariable("user-id") Long userId) {
        return ResponseEntity.ok(service.highestDeposit(userId));

    }


}
