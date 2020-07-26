package com.kirilanastasov.palindrome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kirilanastasov.palindrome.model.Palindrome;

@Repository
public interface PalindromeRepository extends JpaRepository<Palindrome, Long> {

}
