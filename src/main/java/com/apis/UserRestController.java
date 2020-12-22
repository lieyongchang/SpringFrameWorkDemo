package com.apis;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.User;
import com.service.UserInfoService;

/**
 * handle all requests from DataTable component:
 * 
 * @author yongchang
 *
 */
@Controller
public class UserRestController {

	private final UserInfoService userInfoService;

	@Autowired
	public UserRestController(UserInfoService userInfoService) {
		super();
		this.userInfoService = userInfoService;
	}

	@RequestMapping(value = "findall", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Set<User> findAll() {
		// then set my new data as
		return userInfoService.getUser();
	}

}
