/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.wr.unit.admin.repository.jpa;

import com.wr.unit.admin.entity.TreeNode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TreeDao extends PagingAndSortingRepository<TreeNode, Long> {

    public List<TreeNode> findByParentId(Long parentId);

    @Query(value = "From TreeNode t  where t.parent.id is null ")
    public List<TreeNode> findByParentIsNull();
}
