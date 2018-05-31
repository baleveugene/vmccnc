package com.springapp.mvc.dao;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.*;
import org.hibernate.Criteria;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class HbmDAOImpl <T, pk extends Serializable>  implements HbmDAO <T, pk>  {

    @Autowired
    private SessionFactory sessionFactory;
  
    public HbmDAOImpl() {
    }

    @Override
    public void add(T t) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(t);
    }

    @Override
    public List getAll(Class entityClass) {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(entityClass)
                .list();
    }
    
    @Override
    public List getAll(Class entityClass, List<Criterion> restrictions) {
        
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(entityClass);
     
        for( Criterion restr: restrictions ){
            crit.add(restr);
            System.out.println(restr);
        }  
        return crit.list();
    }

    @Override
    public T getById(Class entityClass, pk key) {
        Session session = sessionFactory.getCurrentSession();       
        return (T)session.get(entityClass, key);
    }
    
    @Override
    public T getByUrl(Class entityClass, pk url) {
        Session session = sessionFactory.getCurrentSession();       
        return (T)session.getNamedQuery(entityClass.getSimpleName()+".findByUrl")
                .setParameter("url", url).uniqueResult();
    }

    @Override
    public void deleteFromDbById (Class entityClass, pk key){
        Session session = sessionFactory.getCurrentSession();      
        session.delete( getById(entityClass, key) );   
    }
    
    @Override
    public List getListByIds(Class entityClass, String [] idsArr){
     Criteria criteria = sessionFactory.getCurrentSession().createCriteria(entityClass);
     if (idsArr != null && !idsArr[0].equals("") )   criteria.add(Restrictions.in("id",  idsArr));
        return criteria.list(); 
    } 
    
    @Override
    public List getListFromSearch(Class entityClass, String word){
    return sessionFactory.getCurrentSession().createQuery("from "+entityClass.getSimpleName()+" where model LIKE '%"+word+"%' ORDER BY model DESC").list();
    } 

    }
