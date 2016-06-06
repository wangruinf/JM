/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.wr.unit.admin.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.validation.Valid;

import com.wr.unit.admin.entity.Role;
import com.wr.unit.admin.entity.Team;
import com.wr.unit.admin.entity.User;
import com.wr.unit.admin.service.AccountService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springside.modules.mapper.JsonMapper;
import org.springside.modules.web.Servlets;
import org.springside.modules.web.WebPageFactory;


@Controller
public class UserController {

	@Autowired
	private AccountService accountService;

	// 特别设定多个ReuireRoles之间为Or关系，而不是默认的And.
	//@RequiresRoles(value = { "Admin", "User" }, logical = Logical.OR)
	@RequestMapping(value = "sys/admin/users", method = RequestMethod.GET)
	public String list(Model model, ServletRequest request) {
		return "manage/manage_user_list";
	}

    @RequestMapping(value = "/sys/admin/user_json")
    public void listPage(ServletRequest request, ServletResponse response) {
        PageRequest pageRequest = WebPageFactory.buildJqGridPage(request);
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
        Page<User> page = accountService.searchUserByPage(searchParams, pageRequest);
        Map responce = new HashMap();
        responce.put("page" , page.getNumber() + 1);
        responce.put("total", page.getTotalPages());
        responce.put("records", page.getTotalElements());
        responce.put("rows", page.getContent());

        JsonMapper jsonMapper = JsonMapper.nonEmptyMapper();
        try {
            response.getWriter().print(jsonMapper.toJson(responce));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@RequestMapping(value = "/sys/admin/user/update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, Model model) {

        User user = accountService.getUser(id);
		model.addAttribute("bean", user);
        List<Team> teamList = accountService.getAllTeam();
        model.addAttribute("teams", teamList);
        List<Role> roleList = accountService.getAllRole();
        model.addAttribute("roles", roleList);
		return "manage/manage_user_edit";
	}

	/**
	 * 演示自行绑定表单中的checkBox roleList到对象中.
	 */
	@RequestMapping(value = "/sys/admin/user/do_update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("user") User user,
			@RequestParam(value = "roleList") List<Long> checkedRoleList, RedirectAttributes redirectAttributes) {
		user.getRoleList().clear();
		for (Long roleId : checkedRoleList) {
			Role role = new Role(roleId);
			user.getRoleList().add(role);
		}
		accountService.saveUser(user);
		redirectAttributes.addFlashAttribute("message", "保存用户成功");
		return "redirect:/sys/admin/users";
	}



	/**
	 * 所有RequestMapping方法调用前的Model准备方法, 实现Struts2 Preparable二次部分绑定的效果,先根据form的id从数据库查出User对象,再把Form提交的内容绑定到该对象上。
	 * 因为仅update()方法的form中有id属性，因此仅在update时实际执行.
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value = "id", defaultValue = "-1") Long id, Model model) {
		if (id != -1) {
			model.addAttribute("user", accountService.getUser(id));
		}
	}

	/**
	 * 不自动绑定对象中的roleList属性，另行处理。
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("roleList");
	}
}
