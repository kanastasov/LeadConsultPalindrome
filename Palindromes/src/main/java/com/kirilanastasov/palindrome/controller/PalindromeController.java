package com.kirilanastasov.palindrome.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kirilanastasov.palindrome.customValidator.PalindromeValidator;
import com.kirilanastasov.palindrome.exceptions.PalindromeNotFoundExceptoin;
import com.kirilanastasov.palindrome.model.Palindrome;
import com.kirilanastasov.palindrome.model.UserInput;
import com.kirilanastasov.palindrome.service.PalindromeService;
import com.kirilanastasov.palindrome.service.UserService;

@Controller 
public class PalindromeController implements WebMvcConfigurer {

	@Autowired
	private PalindromeService palindromeService;
	
	@Autowired
	private UserService userService;


	@GetMapping("/")
	public String showAllPalindromes(Model model) {
		model.addAttribute("listPalindromes", palindromeService.getAllPalindromes());
		return "index";

	}

	// create model attribute to bind form data
	@GetMapping("/showPalindromeForm")
	public String showNewPalindromeForm(Model model) {
		Palindrome palindrome = new Palindrome();
		model.addAttribute("palindrome", palindrome);
		return "newPalindrome";
	}

	
	@PostMapping("/saveUserInput")
	public String saveUserInput(@ModelAttribute("palindrome")UserInput userInput
		) {
		userService.saveUserInput(userInput);
		return "index";
	}

	
	@PostMapping("/savePalindrome")
	public String savePalindrome(@ModelAttribute("palindrome")  Palindrome palindrome, UserInput userInput, BindingResult bindingResult) {
		
		userInput.setUserInput(palindrome.getInputPalindrome());
		userService.saveUserInput(userInput);
		
		if (bindingResult.hasErrors() || !palindromeService.isPalindrome(palindrome.getInputPalindrome())) {
			return "newPalindrome";
		}
		List<String> subPalindromeList = palindromeService.palindromeSubStrs(palindrome.getInputPalindrome());
		palindrome.setSubPalindromes(subPalindromeList.toString());
		palindromeService.savePalindrome(palindrome);
		return "redirect:/";
	}


	@GetMapping("/deletePalindrome/{id}")
	public String deletePalindrome(@PathVariable(value = "id") long id) {
		palindromeService.deletePalindromeById(id);
		return "redirect:/";
	}

}
