package com.kazm.translate.dao.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kazm.translate.dao.OrderDao;
import com.kazm.translate.dict.OrderStatusEnum;
import com.kazm.translate.model.OrderModel;

@Repository
public class OrderDaoImpl extends GenericDaoImpl<OrderModel, Long> implements
		OrderDao {

	public OrderDaoImpl() {
		super(OrderModel.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<OrderModel> getOpenOrder() {
		String query = "select o from " + getPersistentClass().getSimpleName()
				+ " o where o.status = :status";
		return getEntityManager().createQuery(query)
				.setParameter("status", OrderStatusEnum.OPEN).getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<OrderModel> getClientOrder(Long id) {
		if (id == null)
			return Collections.emptyList();
		String query = "select o from " + getPersistentClass().getSimpleName()
				+ " o inner join o.client c where c.id = :id";
		return getEntityManager().createQuery(query).setParameter("id", id)
				.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<OrderModel> getTranslatorOrder(Long id) {
		if (id == null)
			return Collections.emptyList();
		String query = "select o from " + getPersistentClass().getSimpleName()
				+ " o inner join o.worker w where w.id = :id";
		return getEntityManager().createQuery(query).setParameter("id", id)
				.getResultList();
	}

}
