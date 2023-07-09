package com.bank.first_bank.services;

import com.bank.first_bank.dto.TransactionDto;

import java.util.List;

public interface TransactionService extends AbstractService<TransactionDto>{

    List<TransactionDto> findAllByUserId(Long userId);
}
