package com.apis;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.User;
import com.model.User.GENDER;
import com.repository.UserRepository;
import com.service.UserInfoService;

import Validator.UserValidator;

/**
 * handle all requests from DataTable component:
 * 
 * @author yongchang
 *
 */
@Controller
public class UserRestController {

	private final UserInfoService userInfoService;
	private final UserRepository userRepository;

	@Autowired
	public UserRestController(UserInfoService userInfoService, UserRepository userRepository) {
		super();
		this.userInfoService = userInfoService;
		this.userRepository = userRepository;
	}

	@RequestMapping(value = "findall", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Set<User> findAll() {
		// then set my new data as
		return userInfoService.getUser();
	}

	@RequestMapping(value = "/yc")
	@ResponseBody
	public String createServlet(HttpServletRequest request) {
		// fetcch the dats
		//@formatter:off
		String name    = request.getParameter("name");
		Integer age    = Integer.parseInt(request.getParameter("age"));
		String gender =  request.getParameter("gender");
		Integer mobile = Integer.parseInt(request.getParameter("mobile"));
		String email   = request.getParameter("email");
		String message = request.getParameter("message");

		// ini my user, with values fetch from servlet
		User user = new User();
		user.setName(name);
		user.setAge(age);
		user.setGender(GENDER.valueOf(gender));
		user.setMobile(mobile);
		user.setEmail(email);
		user.setMessage(message);
		
		UserValidator userValidator = new UserValidator();
		return userValidator.validateServletRequest(user, userRepository, userInfoService);

		

	}

}
