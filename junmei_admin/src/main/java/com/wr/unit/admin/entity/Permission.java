package com.wr.unit.admin.entity;

import javax.persistence.*;

/**
 * 资源对应表
 * Created by wangrui on 2015/6/19.
 */

@Entity
@Table(name = "sys_permission")
public class Permission extends IdEntity {
    private String code;            // 权限代码
    private Role role;

    public Permission() {
    }

    public Permission(Long id){
        this.id = id;
    }

    @Column( length = 127)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @ManyToOne
    @JoinColumn(name = "role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
