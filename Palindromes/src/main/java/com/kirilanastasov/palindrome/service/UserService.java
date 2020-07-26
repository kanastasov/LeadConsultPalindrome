package com.kirilanastasov.palindrome.service;

import java.util.List;

import com.kirilanastasov.palindrome.model.UserInput;

public interface UserService {
	List<UserInput> getAllUserInput();
	void saveUserInput(UserInput userInput);
}
