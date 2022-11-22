package com.centime.application.service;

import org.springframework.stereotype.Service;

import com.centime.application.exception.UserNotFoundException;
import com.centime.application.model.AppUser;

@Service
public interface AppUserService {



	public String search();

	public AppUser search(Long id) throws UserNotFoundException;


}
