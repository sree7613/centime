package com.centime.application.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonProperty("ParentId")
	@Column(name = "parent_id", nullable = false)
	private Integer parentId;
	@JsonProperty("UserName")
	@Column(name = "user_name", length = 50, nullable = false)
	private String userName;
	@JsonProperty("Color")
	@Column(name = "color", length = 50, nullable = false)
	private String color;

	/**
	 * No-arg constructor.
	 */
	public AppUser() {
		super();
	}

	/**
	 * @param parentId
	 * @param userName
	 * @param color
	 */
	public AppUser(Integer parentId, String userName, String color) {
		super();
		this.parentId = parentId;
		this.userName = userName;
		this.color = color;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, id, parentId, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppUser other = (AppUser) obj;
		return Objects.equals(color, other.color) && Objects.equals(id, other.id)
				&& Objects.equals(parentId, other.parentId) && Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "AppUser [id=" + id + ", parentId=" + parentId + ", userName=" + userName + ", color=" + color + "]";
	}

}
