package com.centime.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.centime.application.model.HelloUser;

@RestController
@RequestMapping(value = "/centime/api")
public class UserController {

	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> user(@RequestBody HelloUser user) {
		if (null != user) {
			if(user.getName() == null || 
				user.getSurName() == null) {
				return ResponseEntity.ok("Name and Surname Values are mandatory!!");
			}
			return ResponseEntity.ok(user.getName() + " " + user.getSurName());
		} else {
			return ResponseEntity.ok("No User");
		}
	}
}
