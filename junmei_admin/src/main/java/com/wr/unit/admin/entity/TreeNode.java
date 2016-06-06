package com.wr.unit.admin.entity;

import com.google.common.collect.Lists;

import javax.persistence.*;
import java.util.List;

/**
 * Created by wangrui on 2015/7/2.
 */
@Entity
@Table(name = "sys_tree_node")
public class TreeNode<T> extends IdEntity{
    private String name;
    private TreeNode parent;
    private Integer treeOrder;
    private String treeFlag;
    private List<TreeNode> childs = Lists.newArrayList();
    //private List<T> datas = Lists.newArrayList();

    @Column(length = 32, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id")
    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Column(length = 32, nullable = false)
    public String getTreeFlag() {
        return treeFlag;
    }

    public void setTreeFlag(String treeFlag) {
        this.treeFlag = treeFlag;
    }

    @OneToMany(mappedBy = "parent")
    public List<TreeNode> getChilds() {
        return childs;
    }

    @Column
    public Integer getTreeOrder() {
        return treeOrder;
    }

    public void setTreeOrder(Integer treeOrder) {
        this.treeOrder = treeOrder;
    }

    public void setChilds(List<TreeNode> childs) {
        this.childs = childs;
    }
/**
    @OneToMany(mappedBy = "datas")
    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }**/
}
