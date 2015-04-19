package com.kazm.translate.ctrl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kazm.translate.dict.RoleEnum;
import com.kazm.translate.manager.DaoManager;
import com.kazm.translate.model.RoleModel;
import com.kazm.translate.model.UserModel;
import com.kazm.translate.tools.Dictionary;
import com.kazm.translate.tools.Tools;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	DaoManager mana;

	public DaoManager getMana() {
		return mana;
	}

	public void setMana(DaoManager mana) {
		this.mana = mana;
	}

	@RequestMapping(value = "")
	public String register(HttpServletRequest request, Model model) {
		System.out.println(request.getContextPath());
		return "register/register";
	}

	@RequestMapping(value = "/addUser")
	public String addUser(HttpServletRequest request, UserModel user,
			@RequestParam String mainRole, Model model, RedirectAttributes ra) {

		boolean emailReserved = getMana().getUserDao().checkEmailIfReserved(
				user.getEmail());
		if (emailReserved == true) {
			model.addAttribute("error", Dictionary.REGISTER_ERROR_EMAIL_USED);
			return "/register/register";
		}

		UserModel userCheck = getMana().getUserDao().findByUsername(
				user.getUsername());
		String hash;

		if (userCheck == null) {

			user.setActivated("N");
			user.setLevel("N");
			hash = Tools.getHash();
			user.setHash(hash);

			String password = user.getPassword();
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(password);
			user.setPassword(encodedPassword);
			RoleModel mainRoleModel = new RoleModel();
			if (mainRole.equals(RoleEnum.ROLE_CLIENT.name())) {
				user.setMainRole(RoleEnum.ROLE_CLIENT);
				mainRoleModel.setRole(RoleEnum.ROLE_CLIENT.name());
			} else if (mainRole.equals(RoleEnum.ROLE_TRANSLATOR.name())) {
				user.setMainRole(RoleEnum.ROLE_TRANSLATOR);
				mainRoleModel.setRole(RoleEnum.ROLE_TRANSLATOR.name());
			}

			UserModel userTemp = getMana().getUserDao().save(user);

			mainRoleModel.setUser(userTemp);
			getMana().getRoleDao().save(mainRoleModel);

			RoleModel role = new RoleModel();
			role.setRole(RoleEnum.ROLE_USER.name());
			role.setUser(userTemp);
			getMana().getRoleDao().save(role);
			if ("admin".equals(user.getUsername())) {
				role = new RoleModel();
				role.setRole(RoleEnum.ROLE_ADMIN.name());
				role.setUser(userTemp);
				getMana().getRoleDao().save(role);
				userTemp.setMainRole(RoleEnum.ROLE_ADMIN);
				userTemp.setActivated("Y");
				getMana().getUserDao().update(userTemp);
				System.out.println("poszlo");
			}

		} else {
			model.addAttribute("error", Dictionary.REGISTER_ERROR_LOGIN_USED);
			return "/register/register";
		}

		userCheck = getMana().getUserDao().findByUsername(user.getUsername());

		// Tools.sendMail(userCheck.getId(), hash, userCheck.getEmail(),
		// Tools.getRootUrl(request));

		ra.addFlashAttribute("info", Dictionary.INFO_NEED_TO_CONFIRM_EMAIL);
		return "redirect:/";
	}

	@RequestMapping(value = "/confirm/{id}/hash/{conf}")
	public String confirmPassword(@PathVariable long id,
			@PathVariable String conf, Model model, RedirectAttributes ra) {

		UserModel user = getMana().getUserDao().findById(id);

		if (user.getHash().equals(conf)) {
			user.setActivated("Y");
			getMana().getUserDao().update(user);
			return "redirect:/register/confirmed";
		} else {
			return "redirect:/register/notConfirmed";
		}
	}

	@RequestMapping(value = "/confirmed")
	public String confirmed(Model model, RedirectAttributes ra) {
		ra.addFlashAttribute("info", Dictionary.EMAIL_CONFIRM_MSG);
		return "redirect:/";
	}

	@RequestMapping(value = "/noyConfirmed")
	public String notConfirmed(Model model, RedirectAttributes ra) {
		ra.addFlashAttribute("error", Dictionary.EMAIL_NOT_CONFIRM_MSG);
		return "redirect:/";
	}

}
