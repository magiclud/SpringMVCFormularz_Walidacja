package net.codejava.spring.controller;

import net.codejava.spring.model.User;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component("registrationValidator")
public class RegistrationValidation {

	public boolean supports(Class<?> klass) {
		return User.class.isAssignableFrom(klass);
	}

	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"NotEmpty.registration.userName",
				"User Name must not be Empty.");
		String userName = user.getUsername();
		if ((userName.length()) > 50) {
			errors.rejectValue("userName",
					"lengthOfUser.registration.userName",
					"User Name must not more than 50 characters.");
		}
		if (!(user.getPassword()).equals(user.getPassword())) {
			errors.rejectValue("password",
					"matchingPassword.registration.password",
					"Password and Confirm Password Not match.");
		}
	}
}
