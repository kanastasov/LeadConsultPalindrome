package com.kirilanastasov.palindrome.exceptions;

public class PalindromeNotFoundExceptoin extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PalindromeNotFoundExceptoin(Long id) {
		super("Palindrome not found  with id: " + id);
	}

}
