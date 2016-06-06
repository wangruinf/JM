/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.wr.unit.admin.repository.jpa;

import com.wr.unit.admin.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UserDao extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {
	User findByName(String name);
	User findByLoginName(String loginName);

    @Query("From User u LEFT OUTER JOIN u.roleList where u.id = :id")
    User findUserLoadRole(@Param("id")Long id);
}
