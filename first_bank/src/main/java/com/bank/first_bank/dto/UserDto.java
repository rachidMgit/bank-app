package com.bank.first_bank.dto;

import com.bank.first_bank.models.User;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDto {
    private Long id;
    @NotNull
    @NotEmpty
    @NotBlank
    private String firstName;
    @NotNull
    @NotEmpty
    @NotBlank
    private String name;
    @NotNull
    @NotEmpty
    @NotBlank
    @Email(message = "le mail n'est pas conforme ex: exmple@google.com")
    private String email;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 8, max = 16,message = "le mot de passe doit être compris entre 8 et 16 caractères")
    private String password;

    private String iban;

    private boolean active;

    public static UserDto fromEntity(User user) {

        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .name(user.getName())
                .email(user.getEmail())
                .iban(user.getAccount() == null ? "" : user.getAccount().getIban())
                .active(user.isActive())
                .build();
    }

    public static User toEntity(UserDto user) {

        return User.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
