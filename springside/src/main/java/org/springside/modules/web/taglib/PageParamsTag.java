package org.springside.modules.web.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class PageParamsTag extends BodyTagSupport{
	

	private static final long serialVersionUID = 1L;
	private String name;
	private String value;
	private boolean sign;
	public void setName(String name) {
		this.name = name;
	}
	public void setValue(String value) {
		this.value = value;
		this.sign = true;
	}
	
    public int doEndTag()throws JspException
	{
    	PageParam param = (PageParam) findAncestorWithClass(this, PageParam.class);
	    if(param != null)
	    {
	        if(!sign && bodyContent != null)
	            value = bodyContent.getString();
	        if(value != null)
	            param.addParam(name, value);
	    }
	    return EVAL_PAGE;
	}
}
