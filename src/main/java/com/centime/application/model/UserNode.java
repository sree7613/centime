package com.centime.application.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserNode {
	long parentId;
	long userId;

	@JsonProperty("Name")
	String userName;

	@JsonProperty("Sub Classes")
	@JsonInclude(Include.NON_EMPTY)
	List<UserNode> userNodes;

	public UserNode() {
		super();
		this.userNodes = new ArrayList<>();
	}

	public UserNode(long parentId, long userId, String userName) {
		super();
		this.parentId = parentId;
		this.userId = userId;
		this.userName = userName;
		this.userNodes = new ArrayList<>();
	}

	public long getParentId() {
		return parentId;
	}

	@JsonIgnore
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	@JsonIgnore
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<UserNode> getUserNodes() {
		return userNodes;
	}

	public void setUserNodes(List<UserNode> userNode) {
		this.userNodes = userNode;
	}
}
