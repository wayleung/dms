package com.lyb.dms.service;

import java.util.List;
import java.util.Map;

import com.lyb.dms.domain.Admin;

public interface IAdminService {
	void insertAdmin(Admin admin);
	
	void deleteAdmin(Integer admin_id);
	
	void updateAdmin(Admin admin);
	
	List<Admin> queryAllAdmins();
	
	Admin queryAdminById(Integer admin_id);
	
	Admin queryAdminByAccount(String account);
	
	Map<String, Object> adminLogin(String account,String password);
}
