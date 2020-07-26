package com.kirilanastasov.palindrome.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kirilanastasov.palindrome.model.UserInput;

public interface UserRepository extends JpaRepository<UserInput, Long> {

}
