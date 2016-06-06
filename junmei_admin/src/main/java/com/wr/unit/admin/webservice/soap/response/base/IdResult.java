/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.wr.unit.admin.webservice.soap.response.base;

import com.wr.unit.admin.webservice.soap.WsConstants;

import javax.xml.bind.annotation.XmlType;



/**
 * 创建某个对象返回的 通用IdResult.
 * 
 * @author badqiu
 */
@XmlType(name = "IdResult", namespace = WsConstants.NS)
public class IdResult extends WSResult {
	private Long id;

	public IdResult() {
	}

	public IdResult(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
