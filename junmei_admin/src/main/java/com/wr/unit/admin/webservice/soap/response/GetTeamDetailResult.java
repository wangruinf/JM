/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.wr.unit.admin.webservice.soap.response;

import com.wr.unit.admin.webservice.soap.WsConstants;
import com.wr.unit.admin.webservice.soap.response.base.WSResult;
import com.wr.unit.admin.webservice.soap.response.dto.TeamDTO;

import javax.xml.bind.annotation.XmlType;



@XmlType(name = "GetTeamDetailResult", namespace = WsConstants.NS)
public class GetTeamDetailResult extends WSResult {

	private TeamDTO team;

	public GetTeamDetailResult() {
	}

	public GetTeamDetailResult(TeamDTO team) {
		this.team = team;
	}

	public TeamDTO getTeam() {
		return team;
	}

	public void setTeam(TeamDTO team) {
		this.team = team;
	}
}
