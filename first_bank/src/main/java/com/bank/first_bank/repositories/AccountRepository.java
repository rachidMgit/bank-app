package com.bank.first_bank.repositories;

import com.bank.first_bank.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByIban(String iban);

    Optional<Account> findByUserId(Long id);
}
