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

public class Role extends AbstractEntity {


    private String name;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
