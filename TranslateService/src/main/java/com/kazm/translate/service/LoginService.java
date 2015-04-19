package com.kazm.translate.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.kazm.translate.manager.DaoManager;
import com.kazm.translate.model.RoleModel;
import com.kazm.translate.model.UserModel;

@Service("LoginService")
@Repository
public class LoginService implements UserDetailsService {
	
	@Autowired
	private DaoManager mana;
	
	public DaoManager getMana() {
		return mana;
	}

	public void setMana(DaoManager mana) {
		this.mana = mana;
	}



	@Override
	public UserDetails loadUserByUsername(String username) {
	   
	    	
		System.out.println("username: " + username);

		UserModel user = getMana().getUserDao().findByUsername(username);

		System.out.println("username Dao: " + user.getUsername());

		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		List<RoleModel> roles = getMana().getRoleDao().getRoles(user);

		for (RoleModel role : roles) {
			System.out.println("username Role: " + role.getRole());
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		if(!user.getActivated().equals("Y")){
	    	    return new User(user.getUsername(), user.getPassword(), false, true,
				true, true, authorities);	
	    	}
		else{
	    	return new User(user.getUsername(), user.getPassword(), true, true,
			true, true, authorities);
	    	}
	}

}
