package com.lyb.dms.serviceImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.lyb.dms.domain.Admin;
import com.lyb.dms.domain.AdminExample;
import com.lyb.dms.domain.Student;
import com.lyb.dms.domain.AdminExample.Criteria;
import com.lyb.dms.mapper.AdminMapper;
import com.lyb.dms.service.IAdminService;

import net.sf.json.JSONObject;
@Service
public class AdminServiceImpl implements IAdminService {
	@Resource
	AdminMapper adminMapper;
	

	@Override
	public void insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminMapper.insertSelective(admin);
	}

	@Override
	public void deleteAdmin(Integer admin_id) {
		// TODO Auto-generated method stub
		adminMapper.deleteByPrimaryKey(admin_id);
	}

	@Override
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminMapper.updateByPrimaryKeySelective(admin);
	}

	@Override
	public List<Admin> queryAllAdmins() {
		// TODO Auto-generated method stub
		
		AdminExample example = new AdminExample();
		return adminMapper.selectByExample(example );
	}

	@Override
	public Admin queryAdminById(Integer admin_id) {
		// TODO Auto-generated method stub
		return adminMapper.selectByPrimaryKey(admin_id);
	}

	@Override
	public Admin queryAdminByAccount(String account) {
		// TODO Auto-generated method stub
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountEqualTo(account);
		List<Admin> list = adminMapper.selectByExample(example );
		if(list!=null&&list.size()==1){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public Map<String, Object> adminLogin(String account, String password) {


		
		// TODO Auto-generated method stub
		Admin admin_select = queryAdminByAccount(account);
		if(StringUtils.isBlank(account)||StringUtils.isBlank(password)){
			//账户密码为空
			Map<String, Object> dataMap =  new HashMap<>();
			dataMap.put("msg","账户密码为空" );
			return dataMap;
		}
		
		
		if(admin_select!=null){
			if(admin_select.getPassword().equals(password)){
				//账号存在且密码正确
				Map<String, Object> dataMap =  new HashMap<>();
				dataMap.put("msg","登录成功" );
				dataMap.put("list",admin_select );
				return dataMap;
			}else{
				//密码错误
				Map<String, Object> dataMap =  new HashMap<>();
				dataMap.put("msg","账号或密码不正确" );
				return dataMap;
			}
		}else{
			//账号不存在
			Map<String, Object> dataMap =  new HashMap<>();
			dataMap.put("msg","账号或密码不正确" );
			return dataMap;
		}
	}
	
	
	

}
