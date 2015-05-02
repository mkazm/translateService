package com.kazm.translate.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.kazm.translate.dao.DocumentDao;
import com.kazm.translate.dao.OrderDao;
import com.kazm.translate.dao.PriceDao;
import com.kazm.translate.dao.RoleDao;
import com.kazm.translate.dao.UserDao;

@Service("mana")
@Repository
public class DaoManager {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private DocumentDao documentDao;

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private PriceDao priceDao;

	public PriceDao getPriceDao() {
		return priceDao;
	}

	public void setPriceDao(PriceDao priceDao) {
		this.priceDao = priceDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public DocumentDao getDocumentDao() {
		return documentDao;
	}

	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

}
