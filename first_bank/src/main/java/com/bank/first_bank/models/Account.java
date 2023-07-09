package com.bank.first_bank.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Account extends AbstractEntity {

    private String iban;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
