package com.kazm.translate.manager;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kazm.translate.model.PriceModel;
import com.kazm.translate.model.RoleModel;
import com.kazm.translate.model.UserModel;

@Service("adminMana")
public class AdminManager {

	@Autowired
	DaoManager mana;

	public DaoManager getMana() {
		return mana;
	}

	public Model setUserEditPage(Model model) {
		List<RoleModel> roleList = getMana().getRoleDao().getAllNormalUsers();
		List<UserModel> userList = new LinkedList<UserModel>();
		for (RoleModel roleModel : roleList) {
			userList.add(roleModel.getUser());
		}
		model.addAttribute("userList", userList);
		return model;
	}

	public Model setModsEditPage(Model model) {
		List<RoleModel> userList = getMana().getRoleDao().getAllModerators();
		model.addAttribute("userList", userList);
		return model;
	}

	public Model setPriceEditPage(Model model) {
		List<PriceModel> priceList = getMana().getPriceDao().findAll();
		model.addAttribute("priceList", priceList);
		return model;
	}

}
