/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.wr.unit.admin.service;

import com.google.common.collect.Maps;
import com.wr.unit.admin.entity.Role;
import com.wr.unit.admin.entity.Team;
import com.wr.unit.admin.entity.User;
import com.wr.unit.admin.entity.UserStatus;
import com.wr.unit.admin.repository.jpa.RoleDao;
import com.wr.unit.admin.repository.jpa.TeamDao;
import com.wr.unit.admin.repository.jpa.UserDao;
import com.wr.unit.admin.service.ShiroDbRealm.ShiroUser;
import com.wr.unit.admin.utils.jms.simple.NotifyMessageProducer;
import com.wr.unit.admin.utils.jmx.ApplicationStatistics;
import com.wr.unit.admin.web.exception.RegistrationException;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.javasimon.aop.Monitored;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.Hibernates;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户管理业务类.
 * 
 * @author calvin
 */
// Spring Service Bean的标识.
@Component
@Transactional
@Monitored
public class RoleService {

	private RoleDao roleDao;

    public Role saveRole(Role role){
        return roleDao.save(role);
    }

    public List<Role> listAllRole(){
        return (List<Role>) roleDao.findAll();
    }

    public Page<Role> listAllRoleByPage( PageRequest pageRequest){
        return roleDao.findAll( pageRequest );
    }

    public Role getRoleById(Long id){
        return roleDao.findOne(id);
    }

    public RoleDao getRoleDao() {
        return roleDao;
    }
    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
