package com.wr.unit.merchandise.service;

import com.wr.unit.admin.entity.User;
import com.wr.unit.merchandise.entity.JMStoreEntityInfo;
import com.wr.unit.merchandise.repository.jpa.JMStoreEntityInfoDao;
import org.javasimon.aop.Monitored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;

import java.util.Map;

/**
 * Created by wangrui on 2015/6/8.
 */
@Component
@Transactional
@Monitored
public class StoreService  {
    @Autowired
    private JMStoreEntityInfoDao jmStoreEntityInfoDao ;

    public JMStoreEntityInfo getJMStoreEntityInfo(Long id){
        return jmStoreEntityInfoDao.findOne(id);
    }

    public JMStoreEntityInfo saveJMStoreEntityInfo(JMStoreEntityInfo jmStoreEntityInfo){
        return jmStoreEntityInfoDao.save(jmStoreEntityInfo);
    }

    public Page<JMStoreEntityInfo> findJMStoreEntityInfosByPage( Map<String, Object> searchParams, PageRequest pageRequest ){
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        Specification<JMStoreEntityInfo> spec = DynamicSpecifications.bySearchFilter(filters.values(), JMStoreEntityInfo.class);
        return jmStoreEntityInfoDao.findAll(spec, pageRequest);
    }

}
