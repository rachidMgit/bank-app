package com.bank.first_bank.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Adresse extends AbstractEntity{


    private String street;
    private Integer number;

    private Integer zipCode;
    private String city;

    private String country;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
