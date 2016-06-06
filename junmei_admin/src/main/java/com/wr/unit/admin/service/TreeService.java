package com.wr.unit.admin.service;

import com.wr.unit.admin.entity.TreeNode;
import com.wr.unit.admin.repository.jpa.TreeDao;
import org.javasimon.aop.Monitored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wangrui on 2015/7/2.
 */
@Component
@Transactional
@Monitored
public class TreeService extends ServiceImpl<TreeNode, Long>{

    public static final Long ROOT_ID = 2L;

    private TreeDao treeDao;

    public List<TreeNode> getRootTrees(){
        return treeDao.findByParentIsNull();
    }

    public List<TreeNode> getTreeNodesByParentId(Long parentId){
        return treeDao.findByParentId(parentId);
    }

    @Autowired
    public void setTreeDao(TreeDao treeDao) {
        this.treeDao = treeDao;
        super.setCrudRepository(treeDao);
    }
}
