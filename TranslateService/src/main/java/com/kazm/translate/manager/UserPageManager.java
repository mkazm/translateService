package com.kazm.translate.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
	    if(userModel!=null){
	    model.addAttribute("user", userModel);
	    }
	return model;
    }
}
