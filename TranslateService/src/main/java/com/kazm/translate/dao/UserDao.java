package com.kazm.translate.dao;

import com.kazm.translate.model.UserModel;


public interface UserDao extends GenericDao<UserModel, Long>  {
	public UserModel findByUsername(String username);
	public boolean checkEmailIfReserved(String email);
}
