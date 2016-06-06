package com.wr.unit.utils.webview;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.util.Assert;

import java.util.*;

/**
 * 树
 * Created by wangrui on 2015/6/24.
 */
public class TableTree4JImpl implements TableTree4J, Comparable {

    private String id;
    private String pid;
    private Boolean isLeaf;
    private Integer order;
    private Map<String , Object> dataObject = new HashMap();

    public TableTree4JImpl(String id, String pid, Boolean isLeaf,Integer order) {
        if( "1".equals(id) && "1".equals(pid)) pid = null;
        this.id = id;
        this.pid = pid;
        this.isLeaf = isLeaf;
        this.order = order;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public void addAttr(String key, Object obj) {
        this.dataObject.put(key, obj);
    }

    @Override
    public Object removeAttr(String key) {
        return this.dataObject.remove(key);
    }

    @Override
    public Object getAttr(String key) {
        return this.dataObject.get(key);
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public int compareTo(Object o) {
        if( o == null || !(o instanceof TableTree4JImpl) ) return -1;
        TableTree4JImpl ohter = (TableTree4JImpl)o;
        if( ohter.getOrder() == null ) return  -1;
        return this.getOrder().compareTo( ohter.getOrder());
    }

    public Boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public Map<String, Object> getDataObject() {
        return dataObject;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", order=" + order +
                '}';
    }
}
