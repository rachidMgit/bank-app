package com.bank.first_bank.repositories;

import com.bank.first_bank.models.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {
}