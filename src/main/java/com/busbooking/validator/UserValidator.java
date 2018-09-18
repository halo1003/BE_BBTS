package com.busbooking.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.busbooking.entities.User;
import com.busbooking.service.UserService;

@Component
public class UserValidator implements Validator {
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		User user = (User) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (user.getUsername().length() < 6 || user.getUsername().length() > 15) {
			errors.rejectValue("username", "Size.userForm.username");
			System.out.println("error: Size username bad request");
		}
		if (userService.loadUserByUsername(user.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
			System.out.println("error: Account already exist");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (user.getPassword().length() < 8 || user.getPassword().length() > 15) {
			errors.rejectValue("password", "Size.userForm.password");
			System.out.println("error: Size password bad request");
		}

		if (!user.getPasswordConfirm().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
			System.out.println("error: Confirm password faild");
		}
	}
}
