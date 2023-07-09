package com.bank.first_bank.services.imlp;

import com.bank.first_bank.dto.AdresseDto;
import com.bank.first_bank.exceptions.ObjectValidator;
import com.bank.first_bank.models.Adresse;
import com.bank.first_bank.repositories.AdresseRepository;
import com.bank.first_bank.services.AdresseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdresseServiceImpl implements AdresseService {

    private final AdresseRepository adresseRepository;
    private ObjectValidator<AdresseDto> validator;
    @Override
    public Long save(AdresseDto dto) {
        validator.validate(dto);
        Adresse adresse= AdresseDto.toEntity(dto);

        return adresseRepository.save(adresse).getId();
    }

    @Override
    public List<AdresseDto> findAll() {
        return adresseRepository.findAll()
                .stream()
                .map(AdresseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AdresseDto findById(Long id) {
        return adresseRepository.findById(id)
                .map(AdresseDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("No adresse found with the ID : " + id));
    }

    @Override
    public void delete(Long id) {
        adresseRepository.deleteById(id);

    }
}
