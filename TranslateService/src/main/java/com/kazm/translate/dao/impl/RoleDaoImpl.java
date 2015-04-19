package com.kazm.translate.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.kazm.translate.dao.RoleDao;
import com.kazm.translate.model.RoleModel;
import com.kazm.translate.model.UserModel;

@Repository
public class RoleDaoImpl extends GenericDaoImpl<RoleModel, Long> implements
		RoleDao {

	public RoleDaoImpl() {
		super(RoleModel.class);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<RoleModel> getRoles(UserModel user) {

		Assert.notNull(user);

		Query query = getEntityManager().createQuery(
				"select r from " + getPersistentClass().getSimpleName()
						+ " r inner join r.user u"
						+ " where u.id = :id").setParameter("id",
				user.getId());

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<RoleModel> getAllNormalUsers() {
	    
		Query query = getEntityManager().createQuery(
				"select r from " + getPersistentClass().getSimpleName()
						+ " r inner join r.user u"
						+ " where r.Role = :role").setParameter("role", "ROLE_USER");

		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<RoleModel> getAllModerators() {
	    
		Query query = getEntityManager().createQuery(
				"select r from " + getPersistentClass().getSimpleName()
						+ " r inner join r.user u"
						+ " where r.Role = :role").setParameter("role", "ROLE_MOD");

		return query.getResultList();
	}

}
