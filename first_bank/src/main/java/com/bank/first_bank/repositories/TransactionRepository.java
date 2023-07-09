package com.bank.first_bank.repositories;

import com.bank.first_bank.dto.TransactionSumDetails;
import com.bank.first_bank.models.Transaction;
import com.bank.first_bank.models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByUserId(Long userId);

    @Query("select sum(t.amount) from Transaction t where t.user.id = :userId")
    BigDecimal findAccountBalance(@Param("userId") Long userId);

    @Query("select max(abs(t.amount)) as amount from Transaction t where t.user.id = :userId and t.type = :transactionType")
    BigDecimal findAccountBalanceByTransactionType(Long userId, TransactionType transactionType);
    @Query("select t.transactionDate as transactionDate, sum(t.amount) as amount from Transaction t where t.user.id = :userId and t.createdDate between :start and :end group by t.transactionDate")
    List<TransactionSumDetails> findSumTransactionByDate(LocalDateTime start, LocalDateTime end, Long userId);
}