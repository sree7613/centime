package com.centime.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centime.application.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	AppUser findByParentIdAndUserName(Integer parentId, String userName);

}
