/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.wr.unit.admin.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.shiro.util.CollectionUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.google.common.collect.ImmutableList;

/**
 * 角色.
 * 
 * @author wangrui
 */
@Entity
@Table(name = "sys_role")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Role extends IdEntity {

	private String name;
	private List<Permission> permissions = Lists.newArrayList();

	public Role() {
	}

	public Role(Long id) {
		this.id = id;
	}

    @Column(length = 63)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @OneToMany(mappedBy = "role")
    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

    @Transient
    public List<String> getPermissionList(){
        if(CollectionUtils.isEmpty( this.getPermissions() )){
            return Lists.newArrayList();
        }
        List<String> permissionList = new ArrayList<String>(this.getPermissions().size());
        for( Permission permission : this.getPermissions()){
            permissionList.add(permission.getCode());
        }
        return permissionList;
    }
}
