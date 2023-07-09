package com.bank.first_bank.models;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Transaction extends AbstractEntity{

    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private String destinationIban;
    @Column(updatable = false)
    private LocalDate transactionDate;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;




}
