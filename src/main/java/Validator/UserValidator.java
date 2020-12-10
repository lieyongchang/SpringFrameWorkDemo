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

		//@formatter:off
		if (user.getContact() == user.getEmail() || 
		    user.getContact() == Integer.toString(user.getMobile())
		   ) 
		{

			errors.rejectValue("name", "your_error_code");
		}

	}

}
