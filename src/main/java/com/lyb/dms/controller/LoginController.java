package com.lyb.dms.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lyb.dms.domain.Admin;
import com.lyb.dms.domain.Student;
import com.lyb.dms.service.IStudentService;
import com.lyb.dms.serviceImpl.AdminServiceImpl;
import com.lyb.dms.serviceImpl.StudentServiceImpl;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/dms")
public class LoginController {

	@Resource
	private StudentServiceImpl studentServiceImpl;
	
	@Resource
	private AdminServiceImpl adminServiceImpl;
	
	
	@RequestMapping(value="/adminLogin",method=RequestMethod.POST)
	public String adminLogin(HttpServletRequest request,HttpServletResponse response,Admin admin){
	
		Map<String, Object> dataMap = adminServiceImpl.adminLogin(admin.getAccount(), admin.getPassword());
		//把adminId存进session
		 Admin admin2 = adminServiceImpl.queryAdminByAccount(admin.getAccount());
		 if(admin2!=null){
			 Integer adminId =admin2.getId();
						//把adminId存进session
			 request.getSession().setAttribute("adminId", adminId);
		 }
		
		
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(dataMap);
		try {
			response.getWriter().write(jsonObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/studentLogin",method=RequestMethod.POST)
	public String studentLogin(HttpServletRequest request,HttpServletResponse response,Student student){
	
		Map<String, Object> dataMap = studentServiceImpl.studentLogin(student.getStudentNum(), student.getPassword());
		 Student student2 = studentServiceImpl.queryStudentByStudentNum(student.getStudentNum());
		 if(student2!=null){
			 Integer studentId =student2.getStudentId();
						//把studentId存进session
						request.getSession().setAttribute("studentId", studentId);
		 }

					JSONObject jsonObject = new JSONObject();
					jsonObject.putAll(dataMap);
					try {
						response.getWriter().write(jsonObject.toString());
					} catch (IOException e) {
						e.printStackTrace();
					}
		return null;
	}
	
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response){
	
		
		request.getSession().setAttribute("studentId", null);
		request.getSession().setAttribute("adminId", null);
		
		return "login.html";
	}
}
