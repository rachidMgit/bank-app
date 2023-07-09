package com.bank.first_bank.services;

import com.bank.first_bank.dto.ContactDto;

import java.util.List;

public interface ContactService extends AbstractService<ContactDto>{
    List<ContactDto> findAllByUserId(Long userId);
}
