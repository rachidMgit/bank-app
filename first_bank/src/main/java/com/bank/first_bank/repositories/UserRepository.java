package com.bank.first_bank.repositories;

import com.bank.first_bank.models.User;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

//    //Recherche par nom
//    List<User> findAllByFirstName(String firstName);
//
//    // Rechercher par une suite de lettre
//    List<User> findAllByFirstNameContaining(String firstName);
//
//
//    // Rechercher par une suite de lettre sans prendre en compte les majuscules
//    List<User> findAllByFirstNameContainingIgnoreCase(String firstName);
//
//
//    // Rechercher par une suite de lettre
//    List<User> findAllByAccount_Iban(String iban);
//
//
//    // Recherhcer un utilsateur par son nom et son email
//    User findByFirstNameContainingIgnoreCaseAndEmail(String firstName, String email);
//
//    @Query("from User u inner join Account a on u.id = a.user.id where a.iban = :iban")
//    List<User> searchByIban(String iban);
//
//    @Query(value = "select * from user u inner join account a on u.id = a.id where a.iban = :iban", nativeQuery = true)
//    List<User> searchByIbanMsyql(String iban);


   Optional<User> findByEmail(String email);
}
