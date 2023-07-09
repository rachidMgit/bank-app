package com.bank.first_bank.services;

import com.bank.first_bank.dto.UserDto;

public interface UserService extends AbstractService<UserDto>{
    Long validateAccount(Long id);
    Long invalidateAccount(Long id);

}
