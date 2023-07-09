package com.bank.first_bank.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Contact extends AbstractEntity{

    private String firstName;
    private String name;

    private String email;

    private String iban;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
