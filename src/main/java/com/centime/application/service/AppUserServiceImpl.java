package com.centime.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.centime.application.exception.UserNotFoundException;
import com.centime.application.model.AppUser;
import com.centime.application.model.UserNode;
import com.centime.application.repository.AppUserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private AppUserRepository repository;

	@Override
	public String search() {
		String response = null;
		List<AppUser> results = repository.findAll();
		if (!CollectionUtils.isEmpty(results)) {
			response = getCollectiveData(results);
		}
		return response ;
	}
	

	private String getCollectiveData(List<AppUser> results) {
		List<UserNode> nodes = new ArrayList<>();
		for (AppUser user : results) {
			if (nodes.isEmpty()) {
				nodes.add(getNewUserObject(user));
			} else if (!findParent(user, nodes)) {
				nodes.add(getNewUserObject(user));
			}
		}

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(nodes);
		} catch (JsonProcessingException e) {
			return null;
		}
	}

	private boolean findParent(AppUser user, List<UserNode> nodes) {
		boolean parentFound = false;
		for (UserNode node : nodes) {
			if (user.getParentId() == node.getUserId()) {
				node.getUserNodes().add(getNewUserObject(user));
				return true;
			} else {
				parentFound = findParent(user, node.getUserNodes());
			}
		}
		return parentFound;
	}

	private UserNode getNewUserObject(AppUser user) {
		return new UserNode(user.getParentId(), user.getId(), user.getUserName());
	}

	@Override
	public AppUser search(Long id) throws UserNotFoundException {
		Optional<AppUser> user = repository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new UserNotFoundException("User not found");
		}
	}

}
