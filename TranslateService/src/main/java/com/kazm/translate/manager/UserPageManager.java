package com.kazm.translate.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kazm.translate.model.OrderModel;
import com.kazm.translate.model.UserModel;

@Service("userPageMana")
public class UserPageManager {
	@Autowired
	DaoManager mana;

	public DaoManager getMana() {
		return mana;
	}

	public Model setUserPageModel(Model model, Authentication auth) {
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			String name = auth.getName();
			setUserPage(model, name);
		}
		return model;
	}

	public Model setUserPageModel(Model model, String username) {
		setUserPage(model, username);
		return model;
	}

	private Model setUserPage(Model model, String username) {
		UserModel userModel = getMana().getUserDao().findByUsername(username);
		if (userModel != null) {
			model.addAttribute("user", userModel);
		}
		return model;
	}

	public Model setOrderListPage(Model model) {
		List<OrderModel> orderList = getMana().getOrderDao().getOpenOrder();
		model.addAttribute("orderList", orderList);
		return model;
	}

	public Model setClientOrderListPage(Model model, Long clientId) {
		List<OrderModel> orderList = getMana().getOrderDao().getClientOrder(
				clientId);
		model.addAttribute("orderList", orderList);
		return model;
	}

	public Model setTranslatingListPage(Model model, Long translatorId) {
		List<OrderModel> orderList = getMana().getOrderDao()
				.getTranslatorOrder(translatorId);
		model.addAttribute("orderList", orderList);
		return model;
	}

}
