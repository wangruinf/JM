package org.springside.modules.web.taglib;

import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class PageTag extends BodyTagSupport{

    private Map<String, String> params;  	// 添加参数
    private Page page; 					// 会话中的分页
    private String formName;  				// 分页名称
    private String action;					// URL

    public void setFormName(String formName) {
        this.formName = formName;
        this.getAttributePage();
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void release()
    {
        this.params = null;  	            // 添加参数
        this.page = null; 					// 会话中的分页
        this.formName = null;  				// 分页名称
        this.action = null;					// URL
    }

    public int doStartTag() throws JspTagException {

        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(1750);
        //分页JS

        sb.append("<script>");
        sb.append("function setPageSize(form,value){ if(!(/^\\d{1,}$/.test(value))){alert('分页只能是数字！');return;} form.submit();}");
        sb.append("function goPageNo(form,value){ form.pageNo.value = value; form.submit();}");
        sb.append("function setPageNo(form,value){ var p1 = /^\\d{1,}$/; if(!p1.test(value)){alert('分页只能是数字！');return ; } form.pageNo.value = value;form.submit();}");
        sb.append("</script>");

        sb.append("<form class='form-inline' name='"+this.formName+"' action='"+this.action+"' method='post'><div class='form-group'>");
        // 分页参数
        if( ! CollectionUtils.isEmpty( this.params ) ){
            for(Map.Entry<String, String> param : this.params.entrySet()){
                sb.append("<input type='hidden' name='"+param.getKey()+"' value='"+param.getValue()+"'>\n");
            }
        }

        String pageSizeStr = "<select id='pageSize' name='size' style='width:72px;' onchange='setPageSize(this.form,this.value)'  class='form-control input-sm'>";
        for(int size : new int[]{5,10,20,50,100,200,1000}){
            if(size == this.page.getSize()){
                pageSizeStr +="<option value='" + size + "' selected='selected'>" + size + "</option>";
            }else{
                pageSizeStr +="<option value='" +size+ "'>" + size + "</option>";
            }
        }
        pageSizeStr +="<select>";

        // 分页内容
        int itemStart = this.page.getNumber() * this.page.getSize() + 1;
        int itemEnd = itemStart - 1 + page.getNumberOfElements();


        sb.append("共" + page.getTotalElements() + "条数据，本页显示[" + itemStart + "-" + itemEnd + "]条,每页" + pageSizeStr);
        sb.append("&nbsp;&nbsp;&nbsp;");
        sb.append("<input class='btn btn-default btn-sm' type='button' " + ((!this.page.hasPrevious()) ? "disabled='disabled'" : "") + " onclick='goPageNo(this.form,0)' name='button' value='首页'/>&nbsp;");
        sb.append("<input class='btn btn-default btn-sm' type='button' " + ((!this.page.hasPrevious()) ? "disabled='disabled'" : "") + " onclick='goPageNo(this.form," + (this.page.getNumber() - 1) + ")' name='button' value='上一页' />&nbsp;");
        sb.append("<input class='btn btn-default btn-sm' type='button' " + ((!this.page.hasNext()) ? "disabled='disabled'" : "") + " onclick='goPageNo(this.form," + (this.page.getNumber() + 1) + ")' name='button' value='下一页'  />&nbsp;");
        sb.append("<input class='btn btn-default btn-sm' type='button' " + ((!this.page.hasNext()) ? "disabled='disabled'" : "") + " onclick='goPageNo(this.form," + (this.page.getTotalPages() - 1) + ")' name='button' value='尾页'/>&nbsp;");
        sb.append("&nbsp;&nbsp;&nbsp;共" + page.getTotalPages() + "页第<input name='page' class='form-control input-sm' style='width:36px;' onblur='setPageNo(this.form,this.value)' value='" + (this.page.getNumber() + 1) + "' type='text' id='pageNo' style='width:20px; border:solid #CCC 1px'/>页");
        sb.append("&nbsp;&nbsp;&nbsp;<input class='btn btn-default btn-sm' type='button' onclick='this.form.submit()' name='button' value='刷新'/>");
        sb.append("</div></form>");

        System.out.println(sb.length());
        System.out.println(sb.capacity());

        JspWriter out = this.pageContext.getOut();

        try {
            out.print( sb.toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println( end - start);
        return 6;
    }

    public void getAttributePage(){
        this.page = (Page) pageContext.findAttribute(this.formName);
        Assert.notNull(this.page, "分页实体类未找到！！");
    }

    public void addParam(String name, String value) {
        if( this.params == null )
            this.params = new HashMap<String, String>();
        this.params.put(name, value);
    }
}

