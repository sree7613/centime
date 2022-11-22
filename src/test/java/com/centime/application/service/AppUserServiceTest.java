package com.centime.application.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.centime.application.exception.UserNotFoundException;
import com.centime.application.model.AppUser;

@SpringBootTest
public class AppUserServiceTest {

	@Autowired
	private AppUserService appUserService;

	
	@Test void getUserById() throws UserNotFoundException
	{
		Long id = 4l;
		AppUser user = appUserService.search(id);
		assertThat(user.getId().equals(id)).isTrue();
	}
	

	@Test void getAllUsers() throws UserNotFoundException
	{
		String users = appUserService.search();
		assertThat(users).isNotNull();
	}


}
