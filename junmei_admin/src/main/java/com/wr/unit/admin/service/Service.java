package com.wr.unit.admin.service;

import java.io.Serializable;

/**
 * Created by wangrui on 2015/7/12.
 */
public interface Service<T, ID extends Serializable> {
    <S extends T> S save(S entity);
    <S extends T> Iterable<S> save(Iterable<S> entities);
    T get(ID id);
    boolean exists(ID id);
    Iterable<T> findAll(Iterable<ID> ids);
    void delete(ID id);
    void delete(T entity);
    void delete(Iterable<? extends T> entities);
}
