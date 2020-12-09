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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.User;

@Controller
class WelcomeController {

	//
	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping("/")
	public String welcome(Model model) {

		User user = new User(null, 0, null, null, null, 0);
		model.addAttribute("user", user);

		return "welcome";
	}

	@PostMapping("/")
	public String submitForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
		System.out.println(user);

		if (bindingResult.hasErrors()) {
			return "welcome";
		} else {

			// insert query
			String insert_qurey = "insert into user(" + "name, age, gender, county ,emai, mobile" + "";

			System.out.print("name: " + user.getName());
			//@formatter:off
			int rows = jdbcTemplate.update(insert_qurey,
					            user.getName(), 
					            user.getAge(), 
					            user.getCountry(), 
					            user.getEmail(),
					            user.getGender(),
					            user.getMobile());
			return "register_success";
		}
		/* return "register_success"; */
	}

	/*
	 * @RequestMapping("/list_contact") public String listContact(Model model) {
	 * 
	 * ContactBusiness business = new ContactBusiness(); List<Contact> contactList =
	 * business.getContactList();
	 * 
	 * model.addAttribute("contacts", contactList);
	 * 
	 * return "contact"; }
	 */
}
