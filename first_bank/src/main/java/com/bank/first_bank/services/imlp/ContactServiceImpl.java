package com.bank.first_bank.services.imlp;

import com.bank.first_bank.dto.ContactDto;
import com.bank.first_bank.exceptions.ObjectValidator;
import com.bank.first_bank.models.Contact;
import com.bank.first_bank.repositories.ContactRepository;
import com.bank.first_bank.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ObjectValidator<ContactDto> validator;

    @Override
    public Long save(ContactDto dto) {
        validator.validate(dto);
        Contact contact= ContactDto.toEntity(dto);
        return contactRepository.save(contact).getId();
    }

    @Override
    public List<ContactDto> findAll() {
        return contactRepository.findAll()
                .stream()
                .map(ContactDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDto findById(Long id) {
        return contactRepository.findById(id)
                .map(ContactDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("No contact found with : " + id));
    }

    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);

    }

    @Override
    public List<ContactDto> findAllByUserId(Long userId) {
        return contactRepository.findAllByUserId(userId)
                .stream()
                .map(ContactDto::fromEntity)
                .collect(Collectors.toList());
    }
}
