package com.project.hms.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.hms.service.UserService;
import com.project.hms.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	//handler method
	@GetMapping
	public String showRegistrationForm(Model model)
	{
		model.addAttribute("user", new UserRegistrationDto());
		return "registration";
	}
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto()
	{
		return new UserRegistrationDto();
	}
	
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("users") UserRegistrationDto registrationDto)
	{
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
}
