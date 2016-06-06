package com.wr.unit.merchandise.repository.jpa;

import com.wr.unit.merchandise.entity.JMStoreEntityInfo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wangrui on 2015/6/8.
 */
public interface JMStoreEntityInfoDao extends PagingAndSortingRepository<JMStoreEntityInfo, Long>, JpaSpecificationExecutor<JMStoreEntityInfo> {
}
