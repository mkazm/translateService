package com.kazm.translate.ctrl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kazm.translate.manager.AdminManager;
import com.kazm.translate.manager.DaoManager;
import com.kazm.translate.model.UserModel;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	DaoManager mana;

	public DaoManager getMana() {
		return mana;
	}

	@Autowired
	AdminManager adminMana;

	public AdminManager getAdminMana() {
		return adminMana;
	}

	public void setAdminMana(AdminManager adminMana) {
		this.adminMana = adminMana;
	}

	@RequestMapping(value = "")
	public String homeAdmin(Model model) {
		return "admin/main";
	}

	@RequestMapping(value = "/activate")
	public String activate(Model model) {
		model = getAdminMana().setUserEditPage(model);
		return "admin/activate";
	}

	@RequestMapping(value = "/activate/{id}")
	public String activateAction(Model model, @PathVariable long id) {
		UserModel user = getMana().getUserDao().findById(id);
		user.setActivated("Y");
		getMana().getUserDao().update(user);
		model = getAdminMana().setUserEditPage(model);
		return "redirect:/admin/activate";
	}

}
