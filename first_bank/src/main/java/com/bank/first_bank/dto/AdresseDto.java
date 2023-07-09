package com.bank.first_bank.dto;

import com.bank.first_bank.models.Adresse;
import com.bank.first_bank.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AdresseDto {
    private Long id;
    private String street;
    private Integer number;

    private Integer zipCode;
    private String city;

    private String country;

    private Long userId;

    public static AdresseDto fromEntity(Adresse adresse) {

        return AdresseDto.builder()
                .id(adresse.getId())
                .street(adresse.getStreet())
                .number(adresse.getNumber())
                .zipCode(adresse.getZipCode())
                .city(adresse.getCity())
                .country(adresse.getCountry())
                .userId(adresse.getUser().getId())
                .build();
    }

    public static Adresse toEntity(AdresseDto adresse) {

        return Adresse.builder()
                .id(adresse.getId())
                .street(adresse.getStreet())
                .number(adresse.getNumber())
                .zipCode(adresse.getZipCode())
                .city(adresse.getCity())
                .country(adresse.getCountry())
                .user(
                        User.builder()
                                .id(adresse.getUserId())
                                .build()
                )

                .build();
    }


}
