package Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.model.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;

		if (user.getContact().equals("0")) {
			return;
		}

		//@formatter:off
		if ((
			user.getContact().equals(user.getEmail()) || 
			user.getContact().equals(Integer.toString(user.getMobile()))
		    )) 
		{
			System.out.println("true");
		} else {
			errors.rejectValue("name", "your_error_code");
		}
	}

}
