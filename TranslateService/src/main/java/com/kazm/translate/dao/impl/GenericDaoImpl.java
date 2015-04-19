package com.kazm.translate.dao.impl;

import java.util.List;
import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.kazm.translate.dao.GenericDao;
import com.kazm.translate.model.BaseModel;

@Transactional
public class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {
	
	private Class<T> persistentClass;
	
	public GenericDaoImpl(Class<T> persistentClass){
		this.persistentClass = persistentClass;
	}
	
	private EntityManager entityManager;	
	
	@Transactional
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Transactional
	public T save(T entity) {
		 getEntityManager().persist(entity);
         return entity;
	}
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@Transactional
	public T update(T entity) {
		 /*
        T mergedEntity = getEntityManager().merge(entity);
        return mergedEntity;
        */
	 getEntityManager().merge(entity);
	 return entity;    	 
	}

	@Transactional
	public void delete(T entity) {
	      if (BaseModel.class.isAssignableFrom(persistentClass)) {
              getEntityManager().remove(
                              getEntityManager().getReference(entity.getClass(),
                                              ((BaseModel)entity).getId()));
      } else {
              entity = getEntityManager().merge(entity);
              getEntityManager().remove(entity);
      }
		
	}

	@Transactional
	public T findById(ID id) {
		T entity = (T) getEntityManager().find(getPersistentClass(), id);
        return entity;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> findAll() {
        return getEntityManager()
                .createQuery("select x from " + getPersistentClass().getSimpleName() + " x")
                .getResultList();
	}

	@Transactional
	public void flush() {
		getEntityManager().flush();
	}

}
