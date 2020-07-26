package com.kirilanastasov.palindrome.service;

import java.util.List;

import com.kirilanastasov.palindrome.exceptions.PalindromeNotFoundExceptoin;
import com.kirilanastasov.palindrome.model.Palindrome;

public interface PalindromeService {
	
	List<Palindrome> getAllPalindromes();
	void savePalindrome(Palindrome palindrome);
	Palindrome getPalindromeById(long id) throws PalindromeNotFoundExceptoin;
	void deletePalindromeById(long id);
	public List<String> palindromeSubStrs(String s);
	public boolean isPalindrome(String text);
	
}
