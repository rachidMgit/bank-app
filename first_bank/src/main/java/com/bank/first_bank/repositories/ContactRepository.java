package com.bank.first_bank.repositories;

import com.bank.first_bank.dto.ContactDto;
import com.bank.first_bank.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findAllByUserId(Long userId);
}