package com.centime.application.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.centime.application.model.HelloUser;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/centime/api")
@Api(value = "onlinestore")
public class HelloUserController {

	@Autowired
	private Environment env;

	private String HELLO_SERVICE_URL;
	private String USER_SERVICE_URL;

	@PostConstruct
	private void init() {
		HELLO_SERVICE_URL = env.getProperty("app.hellourl");
		USER_SERVICE_URL = env.getProperty("app.userurl");
	}

	@RequestMapping(value = "/hello_user", method = RequestMethod.GET)
	public ResponseEntity<String> user() {
		return ResponseEntity.ok("Up");
	}

	@RequestMapping(value = "/hello_user", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> user(@RequestBody HelloUser user) throws URISyntaxException {

		ResponseEntity<String> helloResponse = new RestTemplate().exchange(new URI(HELLO_SERVICE_URL), HttpMethod.GET,
				null, String.class);

		RestTemplate userTemplate = new RestTemplate();
		RequestEntity<HelloUser> request = RequestEntity.post(new URI(USER_SERVICE_URL))
				.accept(MediaType.APPLICATION_JSON).body(user);
		ResponseEntity<String> userResponse = userTemplate.exchange(request, String.class);
		return ResponseEntity.ok(helloResponse.getBody() + " " + userResponse.getBody());
	}
}
