package com.bank.first_bank.services;

import com.bank.first_bank.dto.TransactionSumDetails;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public interface StatisticsService {
    List<TransactionSumDetails> findSumTractionsByDate(LocalDate startDate, LocalDate endDate, Long userId);
    BigDecimal getAccountBalance(Long userId);
    BigDecimal highestTransfert(Long userId);
    BigDecimal highestDeposit(Long userId);

}
