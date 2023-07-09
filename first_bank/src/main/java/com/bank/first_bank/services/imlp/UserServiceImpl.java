package com.bank.first_bank.services.imlp;

import com.bank.first_bank.dto.AccountDto;
import com.bank.first_bank.dto.UserDto;
import com.bank.first_bank.exceptions.ObjectValidator;
import com.bank.first_bank.models.Account;
import com.bank.first_bank.models.User;
import com.bank.first_bank.repositories.UserRepository;
import com.bank.first_bank.services.AccountService;
import com.bank.first_bank.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountService accountService;
    private final ObjectValidator<UserDto> validator;

    @Override
    public Long save(UserDto dto) {
        validator.validate(dto); //Valider l'objet
        User user=UserDto.toEntity(dto);//transformer l'objet vers une entité
        return userRepository.save(user).getId(); //Renvoyer l'id
    }

    @Override
    @Transactional
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        return userRepository.findById(id)
                .map(UserDto::fromEntity)
                .orElseThrow(()->  new EntityNotFoundException("No user found wiht the provide ID :"+ id));
    }

    @Override
    public void delete(Long id) {
        // todo check befor delete
        userRepository.deleteById(id);

    }
    @Transactional
    @Override
    public Long validateAccount(Long id) {
        User user= userRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("No user was found for user account validation"));

        if (user.getAccount() == null){
        // create bank account
        AccountDto account = AccountDto.builder()
                .user(UserDto.fromEntity(user))
                .build();
        var savedAccount = accountService.save(account);
            user.setAccount(
                    Account.builder()
                            .id(savedAccount)
                            .build());
    }
        user.setActive(true);
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public Long invalidateAccount(Long id) {
        User user=userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("No user was found for account validation"));

        user.setActive(false);
        userRepository.save(user);
        return user.getId();
    }
}
