package net.codejava.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import net.codejava.spring.model.User;
import net.codejava.spring.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// @RequestMapping(value = "/register")
public class RegisterController {
	private static final Logger logger = LoggerFactory
			.getLogger(RegisterController.class);

	private Map<String, User> users = null;

	public RegisterController() {
		users = new HashMap<String, User>();
	}

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String listUsers(Map<String, Object> model) {
		logger.info("Returning Registration.jsp page");

		User userForm = new User();
		model.put("user", userForm);
		model.put("userList", userService.listUser());

		userService.addUser(userForm);
		
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
	public String addUser(
			@ModelAttribute("userForm") @Valid User user,
			BindingResult bindingResult, Model model) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		if (bindingResult.hasErrors()) {
			logger.info("Wszedl do if Registration.jsp page");
			logger.error("SOME ERRORS" + bindingResult);
			return "Registration";
		}
		logger.info("Returning RegistrationSuccess.jsp page");
		
		userService.addUser(user);
		
		model.addAttribute("user", user);
		users.put(user.getEmail(), user);

		System.out.println("username: " + user.getUsername());
		System.out.println("password: " + user.getPassword());
		System.out.println("email: " + user.getEmail());
		System.out.println("birth date: " + user.getBirthDate());
		System.out.println("profession: " + user.getProfession());

		return "RegistrationSuccess";
	}

	@RequestMapping("/delete/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId) {

		userService.removeUser(userId);

		return "Registration";
	}

}