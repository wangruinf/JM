package org.springside.modules.web;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.beans.PropertyEditor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangrui on 2015/5/29.
 */
@Deprecated
public class WrWebBindingInitializer implements WebBindingInitializer {

    @Override
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        PropertyEditor propertyEditor = new CustomDateEditor(dateFormat, true );
        webDataBinder.registerCustomEditor(Date. class , propertyEditor);
    }
}
