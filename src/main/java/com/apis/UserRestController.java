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
	private static String DATE_FORMAT = "yyyy-MM-dd";

	@Autowired
	public UserRestController(UserInfoService userInfoService) {
		super();
		this.userInfoService = userInfoService;
	}

	@RequestMapping(value = "findall", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Set<User> findAll() {

		/*
		 * // the date format SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		 * 
		 * // this contain the raw data from my database Set<User> user =
		 * userInfoService.getUser();
		 * 
		 * // 1) iterate through the data to change my date format // 2) then set my
		 * delete button with the hreft // 3) then set my edit button with the hreft for
		 * (User i : user) { // format my date here sdf.format(i.getBirthdate()); }
		 * 
		 */

		// then set my new data as
		return userInfoService.getUser();
	}

}
