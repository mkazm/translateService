package com.kazm.translate.dao;

import java.util.List;

import com.kazm.translate.model.OrderModel;

public interface OrderDao extends GenericDao<OrderModel, Long> {
	List<OrderModel> getOpenOrder();

	List<OrderModel> getClientOrder(Long id);

	List<OrderModel> getTranslatorOrder(Long id);
}
