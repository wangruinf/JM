package com.wr.unit.merchandise.entity;

import com.wr.unit.admin.entity.IdEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * Created by wangrui on 2015/6/2.
 * 分类目录
 */
@Entity
public class JMStoreCatalog extends IdEntity{
    private String title; //分类标题
    private JMStoreSet jmStoreSet;    // 商店
   // private


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @NotNull
    @OneToOne
    @JoinColumn(name = "jmstoreset_id")
    public JMStoreSet getJmStoreSet() {
        return jmStoreSet;
    }

    public void setJmStoreSet(JMStoreSet jmStoreSet) {
        this.jmStoreSet = jmStoreSet;
    }
}
