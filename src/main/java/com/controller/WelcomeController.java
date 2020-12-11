/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.User;
import com.model.User.GENDER;
import com.service.UserInfoService;

import Validator.UserValidator;
import integerEditor.IntegerEditor;

@Controller
class WelcomeController {

	/*
	 * This is so that, empty fields will not throw error when submit the form
	 * 
	 */

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.registerCustomEditor(int.class, new IntegerEditor());
	}

	//
	@Autowired
	UserInfoService userInfoService;

	@GetMapping("/")
	public String welcome(Model model) {

		User user = new User(null, 0, (GENDER) null, null, null, 0, null);
		model.addAttribute("user", user);

		return "welcome";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String submitForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

		/*
		 * Condition to check if the contact field matches with the Email/Mobile field
		 * 
		 */

		if (user.getContact().equalsIgnoreCase("Email")) {
			user.setContact(user.getEmail());
		} else if (user.getContact().equalsIgnoreCase("Mobile") && user.getMobile() != 0) {
			System.out.print("enter here");
			user.setContact(Integer.toString(user.getMobile()));
		}

		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, bindingResult);

		if (bindingResult.hasErrors()) {
			return "welcome";
		} else {
			userInfoService.addUserInfo(user);
			return "register_success";
		}
	}
}
