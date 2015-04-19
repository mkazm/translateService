package com.kazm.translate.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kazm.translate.manager.DaoManager;
import com.kazm.translate.tools.Dictionary;

@Controller
public class LoginController {
    
    @Autowired
    DaoManager mana;

    public DaoManager getMana() {
	return mana;
    }

    public void setMana(DaoManager mana) {
	this.mana = mana;
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
	    @RequestParam(value = "logout", required = false) String logout) {
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
	System.out.println("username Login: " + auth.getName());
	
	ModelAndView model = new ModelAndView();
	if (error != null) {
	    model.addObject("error", Dictionary.LOGIN_ERROR);
	}

	if (logout != null) {
	    model.addObject("msg", Dictionary.LOGOUT_SUCCESS);
	}

	model.setViewName("login");
	return model;

    }
}
