package com.bank.first_bank.services.imlp;

import com.bank.first_bank.dto.ContactDto;
import com.bank.first_bank.dto.TransactionDto;
import com.bank.first_bank.exceptions.ObjectValidator;
import com.bank.first_bank.models.Transaction;
import com.bank.first_bank.models.TransactionType;
import com.bank.first_bank.repositories.TransactionRepository;
import com.bank.first_bank.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final ObjectValidator<TransactionDto> validator;

    @Override
    public Long save(TransactionDto dto) {
        validator.validate(dto);
        Transaction transaction= TransactionDto.toEntity(dto);
        BigDecimal transactionMultiplier = BigDecimal.valueOf(getTransactionMultiplier(transaction.getType()));
        BigDecimal amount = transaction.getAmount().multiply(transactionMultiplier);
        transaction.setAmount(amount);

        return transactionRepository.save(transaction).getId();
    }

    @Override
    public List<TransactionDto> findAll() {
        return transactionRepository.findAll()
                .stream().map(TransactionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDto findById(Long id) {
        return transactionRepository
                .findById(id)
                .map(TransactionDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("Not found transaction id : "+ id));
    }

    @Override
    public void delete(Long id) {
        transactionRepository.deleteById(id);

    }
    private long getTransactionMultiplier(TransactionType type){

        return TransactionType.TRANSFERT == type? -1 : 1;
    }


    @Override
    public List<TransactionDto> findAllByUserId(Long userId) {
        return transactionRepository.findAllByUserId(userId)
                .stream()
                .map(TransactionDto::fromEntity)
                .collect(Collectors.toList());
    }
}
