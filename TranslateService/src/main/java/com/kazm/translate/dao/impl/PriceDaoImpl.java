package com.kazm.translate.dao.impl;

import org.springframework.stereotype.Repository;

import com.kazm.translate.dao.PriceDao;
import com.kazm.translate.model.PriceModel;

@Repository
public class PriceDaoImpl extends GenericDaoImpl<PriceModel, Long> implements
		PriceDao {

	public PriceDaoImpl() {
		super(PriceModel.class);
	}

}
