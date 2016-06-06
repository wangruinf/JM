/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.wr.unit.admin.web;

import com.google.common.collect.Lists;
import com.wr.unit.admin.entity.TreeNode;
import com.wr.unit.admin.service.TreeService;
import com.wr.unit.utils.webview.TableTree4J;
import com.wr.unit.utils.webview.TableTree4JImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springside.modules.mapper.JsonMapper;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
public class TreeController {

	@Autowired
	private TreeService treeService;

    /**
     * 权限列表
     * @param model
     * @param request
     * @return
     */
	@RequestMapping(value = "/sys/admin/tree/list")
	public String list(Model model, ServletRequest request) {
        //List list = treeService.getAllTopTree();
        //request.setAttribute("beans", list);
		return "manage/manage_tree_list";
	}
    @RequestMapping(value = "/sys/admin/tree/list.json/{id}")
    public @ResponseBody List listToJson(@PathVariable(value = "id") Long id) {
        List<TreeNode> list = null;
        if( id.equals( -1l )){
            list = treeService.getRootTrees();
        }else{
            list = treeService.getTreeNodesByParentId(id);
        }

        List treeList = Lists.newArrayList();
        for(TreeNode treeNode : list){
            String treeNodeId = Objects.toString( treeNode.getId() );
            String treeNodePid = treeNode.getParent() == null || treeNode.getParent().getId() == null ? null : Objects.toString(treeNode.getParent().getId());
            Integer order = treeNode.getTreeOrder() == null ? 0 : treeNode.getTreeOrder();

            TableTree4J tableTree4J = new TableTree4JImpl( treeNodeId, treeNodePid, false, treeNode.getTreeOrder());
            tableTree4J.addAttr("name" , treeNode.getName());
            treeList.add(tableTree4J);
        }
        return treeList;
    }
}
