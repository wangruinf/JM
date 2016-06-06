/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.wr.unit.merchandise.web;

import com.wr.unit.merchandise.entity.JMStoreEntityInfo;
import com.wr.unit.merchandise.service.StoreService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springside.modules.mapper.JsonMapper;
import org.springside.modules.web.Servlets;
import org.springside.modules.web.WebPageFactory;

import javax.servlet.ServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


/**
 * LoginController负责打开登录页面(GET请求)和登录出错页面(POST请求)，
 * 
 * 真正登录的POST请求由Filter完成,
 * 
 * @author calvin
 */
@Controller
public class JMStoreController {

    @Autowired
    public StoreService storeService;

    Logger log =  LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/store/app", method = RequestMethod.GET)
	public String appForm( @PathVariable("id") Long id, Model model ) {
        JMStoreEntityInfo jmStoreEntityInfo = storeService.getJMStoreEntityInfo(id);
        model.addAttribute("bean" , jmStoreEntityInfo);
		return "store_app";
	}

	@RequestMapping(value = "/store/do_app", method = RequestMethod.POST)
	public String doApp(@Valid @ModelAttribute("jmStoreEntityInfo") JMStoreEntityInfo jmStoreEntityInfo, Model model) {
        jmStoreEntityInfo.setStatus((byte)0);
        jmStoreEntityInfo.setJmStoreSet(null);
        storeService.saveJMStoreEntityInfo( jmStoreEntityInfo );
        return "store_app_ok";                  //  申请完成
	}

    @RequestMapping(value = "/store/app_list", method = RequestMethod.GET)
    @ResponseBody
    public String appList(Model model ,ServletRequest request) {

        PageRequest pageRequest = WebPageFactory.buildJqGridPage(request);
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");

        Page<JMStoreEntityInfo> page = storeService.findJMStoreEntityInfosByPage(searchParams, pageRequest);
        Map responce = new HashMap();
        responce.put("page" , page.getNumber() + 1);
        responce.put("total", page.getTotalPages());
        responce.put("records", page.getTotalElements());
        responce.put("rows", page.getContent());

        JsonMapper jsonMapper = JsonMapper.nonEmptyMapper();
        return jsonMapper.toJson(responce);         // 返回列表
    }

    @RequestMapping(value = "/store/do_app_examine", method = RequestMethod.POST)
    public String doAppExamine(@RequestParam(value = "id", defaultValue = "-1") Long id  ,@RequestParam(value = "status") Byte status  , Model model) {
        Assert.isTrue(id == -1, "id not null!");
        JMStoreEntityInfo jmStoreEntityInfo = storeService.getJMStoreEntityInfo(id);
        jmStoreEntityInfo.setStatus(status);
        storeService.saveJMStoreEntityInfo( jmStoreEntityInfo );
        return "redirect:store/app_list";
    }


    @ModelAttribute
    public void getJMStoreEntityInfo(@RequestParam(value = "id", defaultValue = "-1") Long id, Model model) {
        if (id != -1) {
            model.addAttribute("jmStoreEntityInfo", storeService.getJMStoreEntityInfo(id));
        }
    }



}
