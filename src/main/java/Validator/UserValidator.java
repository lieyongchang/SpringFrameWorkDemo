package Validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.model.User;
import com.repository.UserRepository;
import com.service.UserInfoService;

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
	
	
	/**
	 * this is to validate my servlet request
	 * @param target
	 * @param userRepository
	 * @param userInfoService
	 * @return
	 */
	public String validateServletRequest(Object target,
			                           UserRepository userRepository,
			                           UserInfoService userInfoService  ) {
		
		
		User user = (User) target;
		if (userInfoService.isEmailExist(user.getEmail()) ||
			userInfoService.isMobileExist(user.getMobile())) {
			System.out.println("got duplicate email/mobile");
			return "Duplicate email/mobile number";
		} else {
			userRepository.save(user);
			return "register_success";
		}
	}
	
	// return true if input in numeric
	public boolean OnlyNumeric(String input) {
		if (StringUtils.isNumeric(input)) {
			return true;
		}
		return false;
	}
	
	// return true if email not valid
	public boolean CheckEmailValid(String email) {
		if (!EmailValidator.getInstance().isValid(email)) {
			return true;
		}
		return false;
	}

}
