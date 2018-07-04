package com.springapp.mvc.dao;

import java.util.List;
import org.hibernate.criterion.Criterion;

public interface HbmDAO <T, pk> {

    public void add(T t);
    public void update(T t);
    public T getById(Class entityClass, pk key);
    public T getByUrl(Class entityClass, pk key);
    public T getByName(Class entityClass, pk name);
    public T getByNamedQueryName(Class entityClass, String param, String value, String namedQueryName);
    public List<T> getAll(Class entityClass);
    public List<T> getAll(Class entityClass, List<Criterion> restrictions);
    public void deleteFromDbById(Class entityClass, pk key);
    public List getListByIds(Class entityClass, String [] idsArr);
    public List getListFromSearch(Class entityClass, String word);

}
