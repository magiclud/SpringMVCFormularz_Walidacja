package net.codejava.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import net.codejava.spring.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {
	private static final Logger logger = LoggerFactory
			.getLogger(RegisterController.class);

	private Map<String, User> users = null;

	public RegisterController() {
		users = new HashMap<String, User>();
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		logger.info("Returning Registration.jsp page");
		User userForm = new User();
		model.put("userForm", userForm);

		List<String> professionList = new ArrayList<>();
		professionList.add("Developer");
		professionList.add("Designer");
		professionList.add("IT Manager");
		model.put("professionList", professionList);

		return "Registration";
	}

	// @RequestMapping(value = "/register",method = RequestMethod.POST)
	// public String processRegistration(@ModelAttribute("userForm") User user,
	// Map<String, Object> model) {
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistration(@Valid User user,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			logger.info("Returning Registration.jsp page");
			return "Registration";
		}
		logger.info("Returning RegistrationSuccess.jsp page");
		model.addAttribute("userForm", user);
		users.put(user.getEmail(), user);

		System.out.println("username: " + user.getUsername());
		System.out.println("password: " + user.getPassword());
		System.out.println("email: " + user.getEmail());
		System.out.println("birth date: " + user.getBirthDate());
		System.out.println("profession: " + user.getProfession());

		return "RegistrationSuccesss";
	}

}