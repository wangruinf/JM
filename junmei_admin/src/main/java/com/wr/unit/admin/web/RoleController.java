/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.wr.unit.admin.web;

import com.google.common.collect.Lists;
import com.wr.unit.admin.entity.Permission;
import com.wr.unit.admin.entity.Role;
import com.wr.unit.admin.entity.TreeNode;
import com.wr.unit.admin.service.RoleService;
import com.wr.unit.admin.service.TreeService;
import com.wr.unit.utils.webview.TableTree4J;
import com.wr.unit.utils.webview.TableTree4JImpl;
import com.wr.unit.utils.webview.TableTree4JUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springside.modules.web.WebPageFactory;

import javax.servlet.ServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
    @Autowired
    private TreeService treeService;

    /**
     * 权限列表
     * @param model
     * @param request
     * @return
     */
	@RequestMapping(value = "/sys/admin/roles")
	public String list(Model model, ServletRequest request) {
        PageRequest pageRequest = WebPageFactory.buildCommonPage(request);
        Page<Role> page = roleService.listAllRoleByPage(pageRequest);
        model.addAttribute("page", page);
		return "manage/manage_role_list";
	}

    /**
     *  资源列表
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/sys/admin/role/permissions")
    public String permissions(Model model, ServletRequest request) {
        return "admin/permission_list";
    }

    @RequestMapping(value = "/sys/admin/role/permissions.json/{id}")
    public @ResponseBody List permissionsJSON(@PathVariable(value = "id") Long id ) {


        if( id == null ) id = TreeService.ROOT_ID;
        List<TreeNode> list = treeService.getTreeNodesByParentId(id);


        List treeList = Lists.newArrayList();
        for(TreeNode treeNode : list){
            treeList.add(TableTree4JUtils.getTreeByTreeNode(treeNode));
        }
        return treeList;
    }


    @RequestMapping(value = "/sys/admin/role/create", method = RequestMethod.GET)
    public String createForm( Model model) {
     //   model.addAttribute("permissions", SystemPermissions.get());
        return "manage/manage_role_create";
    }

	@RequestMapping(value = "/sys/admin/role/update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, Model model) {
        Role role = roleService.getRoleById(id);

		model.addAttribute("bean", role);
     //   model.addAttribute("permissions", SystemPermissions.get());
		return "manage/manage_role_update";
	}

	/**
	 *
	 */
	@RequestMapping(value = "/sys/admin/role/do_update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("Role") Role role,
			@RequestParam(value = "permissionList") List<Long> checkedPermissionList, RedirectAttributes redirectAttributes) {

		// bind roleList
        role.getPermissions().clear();
        for (Long permissionId : checkedPermissionList) {
            Permission permission = new Permission(permissionId);
            role.getPermissions().add(permission);
        }

		redirectAttributes.addFlashAttribute("message", "保存用户成功");
		return "redirect:/sys/admin/roles";
	}



	/**
	 * 所有RequestMapping方法调用前的Model准备方法, 实现Struts2 Preparable二次部分绑定的效果,先根据form的id从数据库查出User对象,再把Form提交的内容绑定到该对象上。
	 * 因为仅update()方法的form中有id属性，因此仅在update时实际执行.

	@ModelAttribute
	public void getUser(@RequestParam(value = "id", defaultValue = "-1") Long id, Model model) {
		if (id != -1) {
			model.addAttribute("user", accountService.getUser(id));
		}
	}
     */
	/**
	 * 不自动绑定对象中的roleList属性，另行处理。

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("roleList");
	}*/
}
