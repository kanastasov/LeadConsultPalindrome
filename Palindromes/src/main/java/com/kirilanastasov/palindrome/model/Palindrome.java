package com.kirilanastasov.palindrome.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.kirilanastasov.palindrome.customValidator.CustomPalindromeValidator;

@Entity
@Table(name = "palindrome")
public class Palindrome {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "inputText cannot be null")
	@Column(name = "input_palindrome")
	@CustomPalindromeValidator
	private String inputPalindrome;
	@Column(name = "sub_palindromes")
	private String subPalindromes;

	public Palindrome() {
		super();
	}

	public Palindrome(long id, @NotNull(message = "inputText cannot be null") String inputPalindrome,
			String subPalindromes) {
		super();
		this.id = id;
		this.inputPalindrome = inputPalindrome;
		this.subPalindromes = subPalindromes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInputPalindrome() {
		return inputPalindrome;
	}

	public void setInputPalindrome(String inputPalindrome) {
		this.inputPalindrome = inputPalindrome;
	}

	public String getSubPalindromes() {
		return subPalindromes;
	}

	public void setSubPalindromes(String subPalindromes) {
		this.subPalindromes = subPalindromes;
	}

}
