package com.lyb.dms.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lyb.dms.domain.Dorm;
import com.lyb.dms.domain.DormManager;
import com.lyb.dms.domain.Student;
import com.lyb.dms.serviceImpl.DormManagerServiceImpl;
import com.lyb.dms.serviceImpl.DormServiceImpl;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/dms")
public class DormManagerController {

	@Resource
	private DormManagerServiceImpl dormManagerServiceImpl;
	
	
	@RequestMapping(value="/insertDormManager",method=RequestMethod.POST)
	public String insertDormManager(HttpServletRequest request,HttpServletResponse response){
		String dmNum = request.getParameter("dmNum");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String remark = request.getParameter("remark");
		DormManager dormManager = new DormManager();
		dormManager.setDmNum(dmNum);
		dormManager.setPassword(password);
		dormManager.setName(name);
		dormManager.setBirthDate(birthDate);
		dormManager.setSex(sex);
		dormManager.setPhone(phone);
		dormManager.setRemark(remark);
		
		dormManagerServiceImpl.insertDormManager(dormManager);
		return null;
	}
	
	@RequestMapping(value="/deleteDormManager",method=RequestMethod.POST)
	public String deleteDormManager(HttpServletRequest request,HttpServletResponse response){
		String id_string = request.getParameter("id");
		if(id_string!=null){
			Integer id =  Integer.parseInt(id_string);
			dormManagerServiceImpl.deleteDormManager(id);
			return null;
		}else{
			return null;
		}
	}
	
	
	@RequestMapping(value="/updateDormManager",method=RequestMethod.POST)
	public String updateDormManager(HttpServletRequest request,HttpServletResponse response){
		String id_string = request.getParameter("id_update");
		String dmNum = request.getParameter("dmNum_update");
		String password = request.getParameter("password_update");
		String name = request.getParameter("name_update");
		String birthDate = request.getParameter("birthDate_update");
		String sex = request.getParameter("sex_update");
		String phone = request.getParameter("phone_update");
		String remark = request.getParameter("remark_update");
		DormManager dormManager = new DormManager();
		dormManager.setDmNum(dmNum);
		dormManager.setPassword(password);
		dormManager.setName(name);
		dormManager.setBirthDate(birthDate);
		dormManager.setSex(sex);
		dormManager.setPhone(phone);
		dormManager.setRemark(remark);
		if(id_string!=null&&!id_string.equals("")){
			Integer id = Integer.parseInt(id_string);
			dormManager.setDmId(id);
		}
		
		dormManagerServiceImpl.updateDormManager(dormManager);
		return null;
	}
	
	
	
	
	@RequestMapping(value="/queryAllDormManagers",method=RequestMethod.POST)
	public String queryAllDormManagers(HttpServletRequest request,HttpServletResponse response){
		List<DormManager> list =  dormManagerServiceImpl.queryAllDormManagers();
		Map<String, List<DormManager>> dataMap =  new HashMap<>();
		dataMap.put("dormManagerList", list);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(dataMap);
		try {
			response.getWriter().write(jsonObject.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/queryDormManagerById",method=RequestMethod.POST)
	public String queryDormManagerById(HttpServletRequest request,HttpServletResponse response){
		String id_string = request.getParameter("id");
		if(id_string!=null){
			Integer id =  Integer.parseInt(id_string);
			DormManager dormManager =  dormManagerServiceImpl.queryDormManagerById(id);
			Map<String, DormManager> dataMap =  new Hashtable<>();
			dataMap.put("dormManager", dormManager);
			JSONObject jsonObject = new JSONObject();
			jsonObject.putAll(dataMap);
			try {
				response.getWriter().write(jsonObject.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
