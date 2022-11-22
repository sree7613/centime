package com.centime.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.centime.application.exception.UserNotFoundException;
import com.centime.application.model.AppUser;
import com.centime.application.service.AppUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/centime/api")
public class ApplicationUserController {

	@Autowired
	private AppUserService appUserService;

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> search() {
		String response = appUserService.search();
		return ResponseEntity.ok(response);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	ResponseEntity<String> searchById(@PathVariable Long id) {

		AppUser user;
		try {
			user = appUserService.search(id);
			return ResponseEntity.ok(new ObjectMapper().writeValueAsString(user));
		} catch (UserNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}


}
