package com.centime.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloUser {
	@JsonProperty(value = "Name")
	private String name;
	@JsonProperty(value = "Surname")
	private String surName;

	public HelloUser() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

}
