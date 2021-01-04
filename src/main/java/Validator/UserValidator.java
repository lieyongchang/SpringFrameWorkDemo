package Validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.model.User;

public class UserValidator implements Validator {

	private String lastMessage;

	public String getLastMessage() {
		return lastMessage;
	}

	public void setLastMessage(String lastMessage) {
		this.lastMessage = lastMessage;
	}

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
	public boolean ValidateInformation(String mobile, String email, String age, String gender) {
		
		boolean hasError = false;
		
		// check to make sure mobile has only numbers
		if(OnlyNumeric(mobile) & CheckMinimumLength(mobile, 6)) 
			System.out.println("Mobile correct format");
		else {
			hasError = true;
			setLastMessage("Input only number and minimum 6 numbers");
		};
		
		// check to validate email is the correct format
		if(!CheckEmailValid(email))
			System.out.println("Email correct format");
		else {
			hasError = true;
			setLastMessage("Email format is wrong");
		}
		
		// make sure age is only numbers
		if(OnlyNumeric(age))
			System.out.println("age Correct format");
		else {
			hasError = true;
			setLastMessage("Input only number in age field");
		}
		
		// gender
		String newGender = gender.toLowerCase();
		// gender
		if(newGender.equals("male") || newGender.equals("female") || newGender.equals("other")) {
			System.out.println("Gender format correct");
		}else if(newGender != "male" || newGender != "female" || newGender != "other") {
			hasError = true;
			setLastMessage("Input either value: male, female, others");
			
		}
		return hasError;
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
	
	// return true if input not a specific length
		public boolean CheckLength(String input, int length) {
			if (input.length() != length) {
				return true;
			}
			return false;
		}

		// return true if input length more than min
		public boolean CheckMinimumLength(String input, int min) {
			if (input.length() >= min) {
				return true;
			}
			return false;
		}

		// return true if input length less than or equal to max
		public boolean CheckMaximumLength(String input, int max) {
			if (input.length() <= max) {
				return true;
			}
			return false;
		}
}
