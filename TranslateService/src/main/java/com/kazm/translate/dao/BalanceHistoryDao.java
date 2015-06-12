package com.kazm.translate.dao;

import java.util.List;

import com.kazm.translate.model.BalanceHistoryModel;

/**
 * @author mateusz.kazmierski 12 cze 2015
 */
public interface BalanceHistoryDao extends GenericDao<BalanceHistoryModel, Long> {

	List<BalanceHistoryModel> getUserBalanceHistory(Long userId);

}
