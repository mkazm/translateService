package com.kazm.translate.ctrl.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kazm.translate.manager.DaoManager;
import com.kazm.translate.manager.UserPageManager;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    DaoManager mana;

    public DaoManager getMana() {
	return mana;
    }

    @Autowired
    UserPageManager userPageMana;

    public UserPageManager getUserPageMana() {
	return userPageMana;
    }

    public void setUserPageMana(UserPageManager userPageMana) {
	this.userPageMana = userPageMana;
    }

    @RequestMapping(value = "")
    public String main(Model model) {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	if (!(auth instanceof AnonymousAuthenticationToken)) {
	    getUserPageMana().setUserPageModel(model, auth);
	}
	return "user/main";
    }
   
}
