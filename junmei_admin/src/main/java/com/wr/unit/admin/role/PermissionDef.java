package com.wr.unit.admin.role;

/**
 * Created by wangrui on 2015/6/18.
 *
 * 系统里的资源   代码里维护
 */
public class PermissionDef{
    private String title;          // 备注
    private String code;            // 权限代码
    private String uri;             // 权限对应的web 资源

    public PermissionDef(String title, String code, String uri) {
        this.code = code;               // 资源代码
        this.title = title;           // 备注
        this.uri = uri;                 // 资源对应WEB uri
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
