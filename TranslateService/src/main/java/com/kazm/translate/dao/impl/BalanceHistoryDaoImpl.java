package com.kazm.translate.dao.impl;

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

}
