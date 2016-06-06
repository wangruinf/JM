package com.wr.unit.merchandise.entity;

import com.wr.unit.admin.entity.IdEntity;
import com.wr.unit.admin.entity.Team;
import com.wr.unit.admin.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by wangrui on 2015/6/2.
 * 网店的设置信息
 */
@Entity
public class JMStoreSet extends IdEntity {
    private String title;  // 网店名称
    private User admin;    // 网店管理员
    private JMStoreEntityInfo jmStoreEntityInfo; // 网店的实体信息
    private List<JMStoreCatalog> catalogList;       // 网店的商品分类
    private Byte status;  // 网店状态

    @Column(length = 32, nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotNull
    @OneToOne
    @JoinColumn(name = "admin_id")
    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }
    @NotNull
    @OneToOne
    @JoinColumn(name = "entity_info_id")
    public JMStoreEntityInfo getJmStoreEntityInfo() {
        return jmStoreEntityInfo;
    }

    public void setJmStoreEntityInfo(JMStoreEntityInfo jmStoreEntityInfo) {
        this.jmStoreEntityInfo = jmStoreEntityInfo;
    }


    @OneToMany(mappedBy = "jmStoreSet")
    public List<JMStoreCatalog> getCatalogList() {
        return catalogList;
    }

    public void setCatalogList(List<JMStoreCatalog> catalogList) {
        this.catalogList = catalogList;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
