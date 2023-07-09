package com.bank.first_bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FirstBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstBankApplication.class, args);
    }

}
