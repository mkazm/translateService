package com.kazm.translate.dao;

import java.util.List;

import com.kazm.translate.model.RoleModel;
import com.kazm.translate.model.UserModel;


public interface RoleDao extends GenericDao<RoleModel, Long> {

	//public RoleModel getRole(UserModel user);
	public List<RoleModel> getRoles(UserModel user);
	public List<RoleModel> getAllNormalUsers();
	public List<RoleModel> getAllModerators();
}
