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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Contact;
import com.model.User;

@Controller
class WelcomeController {

	@GetMapping("/")
	public String welcome(Model model) {

		User user = new User(null, 0, null, null);
		model.addAttribute("user", user);

		Contact contact = new Contact(0, null);
		model.addAttribute("contact", contact);

		return "welcome";
	}

	@PostMapping("/")
	public String submitForm(@ModelAttribute("user") User user, @ModelAttribute("contact") Contact contact) {
		System.out.println(user);
		System.out.println(contact);
		return "register_success";
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
