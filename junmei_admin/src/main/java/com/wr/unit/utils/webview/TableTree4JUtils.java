package com.wr.unit.utils.webview;

import com.google.common.collect.Lists;
import com.wr.unit.admin.entity.TreeNode;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Created by wangrui on 2015/7/13.
 */
public class TableTree4JUtils {
    public static TableTree4J getTreeByTreeNode(TreeNode treeNode){
        Assert.isNull(treeNode , "TreeNode is NULL!");
        String treeNodeId = Objects.toString(treeNode.getId());
        String treeNodePid = treeNode.getParent() == null || treeNode.getParent().getId() == null ? null : Objects.toString(treeNode.getParent().getId());
        Integer order = treeNode.getTreeOrder() == null ? 0 : treeNode.getTreeOrder();

        TableTree4J tableTree4J = new TableTree4JImpl( treeNodeId, treeNodePid, false, order);
        tableTree4J.addAttr("name" , treeNode.getName());
        return tableTree4J;
    }

    public static List<TableTree4J> getTreeByTreeNodes(Collection<TreeNode> treeNodes){
        List<TableTree4J> list = Lists.newArrayList();
        for(Iterator<TreeNode> it = treeNodes.iterator();it.hasNext();){
            list.add(TableTree4JUtils.getTreeByTreeNode(it.next()));
        }
        return list;
    }
}
