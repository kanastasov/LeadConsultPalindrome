package com.kirilanastasov.palindrome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kirilanastasov.palindrome.model.UserInput;
import com.kirilanastasov.palindrome.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public List<UserInput> getAllUserInput() {
		return userRepository.findAll();
	}

	@Override
	public void saveUserInput(UserInput userInput) {
		userRepository.save(userInput);
	}

}
