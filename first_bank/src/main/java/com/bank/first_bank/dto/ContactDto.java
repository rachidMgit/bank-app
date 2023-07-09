package com.bank.first_bank.dto;

import com.bank.first_bank.models.Contact;
import com.bank.first_bank.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ContactDto {
    private Long id;

    private String firstName;
    private String name;

    private String email;

    private String iban;

    private Long user;

    public static ContactDto fromEntity(Contact contact){

        return ContactDto.builder()
                .id(contact.getId())
                .firstName(contact.getFirstName())
                .name(contact.getName())
                .email(contact.getEmail())
                .iban(contact.getIban())
                .user(contact.getUser().getId())
                .build();
    }

    public static Contact toEntity(ContactDto contact){

        return Contact.builder()
                .id(contact.getId())
                .firstName(contact.getFirstName())
                .name(contact.getName())
                .email(contact.getEmail())
                .iban(contact.getIban())
                .user(User.builder().id(contact.getId()).build())
                .build();
    }
}
