package com.bank.first_bank.services.imlp;

import com.bank.first_bank.dto.AccountDto;
import com.bank.first_bank.exceptions.ObjectValidator;
import com.bank.first_bank.exceptions.OperationNonPermittedException;
import com.bank.first_bank.models.Account;
import com.bank.first_bank.repositories.AccountRepository;
import com.bank.first_bank.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final ObjectValidator<AccountDto> validator;

    @Override
    public Long save(AccountDto dto) {
//        if (dto.getId()!= null){
//            throw  new OperationNonPermittedException(
//            " Account can not be updated",
//            "save account",
//            "Account",
//            "Updated not permitted"
//            );
//        }

        validator.validate(dto);
        Account account=AccountDto.toEntity(dto);
        boolean userHasAlreadyAnAccount= accountRepository.findByUserId(account.getUser().getId()).isPresent();
        if (userHasAlreadyAnAccount && account.getUser().isActive()){
            throw new OperationNonPermittedException(
                    "user has already an active account",
                    "Create account",
                    "Account service",
                    "Account creation"
            );
        }
        // generate rendom iban
        if(dto.getId()==null){
        account.setIban(generateRandomIban());
        }
        return accountRepository.save(account).getId();
    }

    @Override
    public List<AccountDto> findAll() {
        return accountRepository.findAll()
                .stream()
                .map(AccountDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto findById(Long id) {
        return accountRepository.findById(id)
                .map(AccountDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("No account was found with the ID : "+ id));
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);

    }

    private String generateRandomIban(){
        //todo generate an iban
        String iban = Iban.random(CountryCode.FR).toFormattedString();
        // check if exist

        boolean ibanExists = accountRepository.findByIban(iban).isPresent();
        // generate if exist
        if(ibanExists){
            generateRandomIban();
        }
        return iban;
    }

}
