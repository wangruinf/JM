/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.wr.unit.admin.webservice.soap.response;

import com.wr.unit.admin.webservice.soap.WsConstants;
import com.wr.unit.admin.webservice.soap.response.base.WSResult;
import com.wr.unit.admin.webservice.soap.response.dto.UserDTO;

import javax.xml.bind.annotation.XmlType;



@XmlType(name = "GetUserResult", namespace = WsConstants.NS)
public class GetUserResult extends WSResult {
	private UserDTO user;

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
