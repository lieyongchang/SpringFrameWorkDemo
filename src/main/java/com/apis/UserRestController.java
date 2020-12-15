package com.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserInfoService;

/**
 * handle all requests from DataTable component:
 * 
 * @author yongchang
 *
 */

@RestController
@RequestMapping("/apis/users")
public class UserRestController {

	@Autowired
	private final UserInfoService userInfoService;

	public UserRestController(UserInfoService userInfoService) {
		super();
		this.userInfoService = userInfoService;
	}

	@RequestMapping(value = "findall", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<User>> findAll() {
		try {
			return new ResponseEntity<Iterable<User>>(userInfoService.getUser(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<User>>(HttpStatus.BAD_REQUEST);
		}
	}

}
