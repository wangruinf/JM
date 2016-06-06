package com.wr.unit.admin.service;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * Created by wangrui on 2015/7/12.
 */
public class ServiceImpl<T, ID extends Serializable> implements Service<T,ID> {

    CrudRepository crudRepository = null;

    @Override
    public <S extends T> S save(S entity) {
        return (S) crudRepository.save(entity);
    }

    @Override
    public <S extends T> Iterable<S> save(Iterable<S> entities) {
        return crudRepository.save(entities);
    }

    @Override
    public T get(ID id) {
        return null;
    }

    @Override
    public boolean exists(ID id) {
        return false;
    }

    @Override
    public Iterable<T> findAll(Iterable<ID> ids) {
        return crudRepository.findAll(ids);
    }

    @Override
    public void delete(ID id) {
        crudRepository.delete(id);
    }

    @Override
    public void delete(T entity) {
        crudRepository.delete(entity);
    }

    @Override
    public void delete(Iterable<? extends T> entities) {
        crudRepository.delete(entities);
    }

    public void setCrudRepository(CrudRepository crudRepository){
        this.crudRepository = crudRepository;
    }
}
