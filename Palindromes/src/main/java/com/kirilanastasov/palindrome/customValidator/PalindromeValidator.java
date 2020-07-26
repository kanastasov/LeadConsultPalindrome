package com.kirilanastasov.palindrome.customValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PalindromeValidator implements ConstraintValidator<CustomPalindromeValidator, String> {

	public boolean isPalindrome(String text) {
	    StringBuilder sb = new StringBuilder(text);
	    String reverseWord = sb.reverse().toString();
	    return text.equals(reverseWord);
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return isPalindrome(value);
	}

}
