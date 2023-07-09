package com.bank.first_bank.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface TransactionSumDetails {

    LocalDate getTransactionDate();
    BigDecimal getAmount();

}
