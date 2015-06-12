package com.kazm.translate.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kazm.translate.dao.BalanceHistoryDao;
import com.kazm.translate.model.BalanceHistoryModel;

/**
 * @author mateusz.kazmierski 12 cze 2015
 */
@Repository
public class BalanceHistoryDaoImpl extends GenericDaoImpl<BalanceHistoryModel, Long> implements BalanceHistoryDao {

	public BalanceHistoryDaoImpl() {
		super(BalanceHistoryModel.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<BalanceHistoryModel> getUserBalanceHistory(Long userId) {
		String query = "select b from " + getPersistentClass().getSimpleName()
				+ " b inner join b.user u where u.id = :userId";
		return getEntityManager().createQuery(query).setParameter("userId", userId).getResultList();
	}

}
