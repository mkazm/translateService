package com.kazm.translate.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.kazm.translate.dao.UserDao;
import com.kazm.translate.model.UserModel;

@Repository
public class UserDaoImpl extends GenericDaoImpl<UserModel, Long> implements UserDao {

    public UserDaoImpl() {
	super(UserModel.class);
    }

    /* PRZY QUEROWANIU WAZNE ZEBY BYLA NAZWA KLASY A NIE NAZWA TABELI */
    @Transactional
    public UserModel findByUsername(String username) {
	// Session session = sessionFactory.getCurrentSession();
	// UserModel user = (UserModel)
	// session.createQuery("select * from user where username = " +
	// username).uniqueResult();
	// return (UserModel)
	// sessionFactory.getCurrentSession().createQuery("from UserModel where username = '"
	// + username + "'").uniqueResult();

	Assert.notNull(username);

	UserModel user = null;

	Query query = getEntityManager().createQuery(
		"select u from " + getPersistentClass().getSimpleName()
			+ " u where u.username = :username").setParameter("username", username);

	try {
	    user = (UserModel) query.getSingleResult();
	} catch (NoResultException e) {
	    // do nothing
	}

	return user;
    }

    @Override
    public boolean checkEmailIfReserved(String email) {
	UserModel user = null;

	Query query = getEntityManager().createQuery(
		"select u from " + getPersistentClass().getSimpleName()
			+ " u where u.email = :email").setParameter("email", email);

	try {
	    user = (UserModel) query.getSingleResult();
	} catch (NoResultException e) {
	    // do nothing
	}
	if (user == null)
	    return false;
	else
	    return true;

    }

}
