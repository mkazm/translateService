package com.kazm.translate.dao.impl;

import org.springframework.stereotype.Repository;

import com.kazm.translate.dao.OrderDao;
import com.kazm.translate.model.OrderModel;

@Repository
public class OrderDaoImpl extends GenericDaoImpl<OrderModel, Long> implements
		OrderDao {

	public OrderDaoImpl() {
		super(OrderModel.class);
	}

}
