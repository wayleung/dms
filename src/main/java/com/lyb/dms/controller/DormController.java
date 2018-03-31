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
import com.lyb.dms.serviceImpl.DormServiceImpl;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/dms")
public class DormController {

	@Resource
	private DormServiceImpl dormServiceImpl;
	
	
	@RequestMapping(value="/insertDorm",method=RequestMethod.POST)
	public String insertDorm(HttpServletRequest request,HttpServletResponse response){
		String dormNum = request.getParameter("dormNum");
		String type = request.getParameter("type");
		String capacity = request.getParameter("capacity");
		String telephone = request.getParameter("telephone");
		String headId = request.getParameter("headId");
		String createTime = request.getParameter("createTime");
		String score = request.getParameter("score");
		String remark = request.getParameter("remark");
		Dorm dorm = new Dorm();
		dorm.setDormNum(dormNum);
		dorm.setType(type);
		dorm.setCapacity(capacity);
		dorm.setTelephone(telephone);
		if(headId!=null&&!headId.equals("")){
			Integer head_id = Integer.parseInt(headId);
			dorm.setHeadId(head_id);
		}
		dorm.setCreateTime(createTime);
		dorm.setScore(score);
		dorm.setRemark(remark);
		if(dormServiceImpl.queryDormByDormNum(dormNum)!=null){
			Map<String, Object> dataMap =  new Hashtable<>();
			dataMap.put("msg_insert", "该宿舍号已经存在！");
			dataMap.put("success", "0");
			JSONObject jsonObject = new JSONObject();
			jsonObject.putAll(dataMap);
			try {
				response.getWriter().write(jsonObject.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			Map<String, Object> dataMap =  new Hashtable<>();
			dataMap.put("msg_insert", "增加成功！");
			dataMap.put("success", "1");
			JSONObject jsonObject = new JSONObject();
			jsonObject.putAll(dataMap);
			try {
				response.getWriter().write(jsonObject.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			dormServiceImpl.insertDorm(dorm);
		}
		
		return null;
	}
	
	@RequestMapping(value="/deleteDorm",method=RequestMethod.POST)
	public String deleteDorm(HttpServletRequest request,HttpServletResponse response){
		String id_string = request.getParameter("id");
		if(id_string!=null){
			Integer id =  Integer.parseInt(id_string);
			dormServiceImpl.deleteDorm(id);
			return null;
		}else{
			return null;
		}
	}
	
	@RequestMapping(value="/updateDorm",method=RequestMethod.POST)
	public String updateDorm(HttpServletRequest request,HttpServletResponse response){
		String id_string = request.getParameter("id_update");
		String dormNum = request.getParameter("dormNum_update");
		String type = request.getParameter("type_update");
		String capacity = request.getParameter("capacity_update");
		String telephone = request.getParameter("telephone_update");
		String headId = request.getParameter("headId_update");
		String createTime = request.getParameter("createTime_update");
		String score = request.getParameter("score_update");
		String remark = request.getParameter("remark_update");
		Dorm dorm = new Dorm();
		dorm.setDormNum(dormNum);
		dorm.setType(type);
		dorm.setCapacity(capacity);
		dorm.setTelephone(telephone);
		if(id_string!=null&&!id_string.equals("")){
			Integer id = Integer.parseInt(id_string);
			dorm.setDormId(id);
		}
		
		
		if(headId!=null&&!headId.equals("")){
			Integer head_id = Integer.parseInt(headId);
			dorm.setHeadId(head_id);
		}
		dorm.setCreateTime(createTime);
		dorm.setScore(score);
		dorm.setRemark(remark);
		dormServiceImpl.updateDorm(dorm);
		return null;
	}
	
	@RequestMapping(value="/queryAllDorms",method=RequestMethod.POST)
	public String queryAllDorms(HttpServletRequest request,HttpServletResponse response){
		List<Dorm> list =  dormServiceImpl.queryAllDorms();
		Map<String, List<Dorm>> dataMap =  new HashMap<>();
		dataMap.put("dormList", list);
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
	
	@RequestMapping(value="/queryDormById",method=RequestMethod.POST)
	public String queryDormById(HttpServletRequest request,HttpServletResponse response){
		String id_string = request.getParameter("id");
		if(id_string!=null){
			Integer id =  Integer.parseInt(id_string);
			Dorm dorm =  dormServiceImpl.queryDormById(id);
			Map<String, Dorm> dataMap =  new Hashtable<>();
			dataMap.put("dorm", dorm);
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
	
	
	@RequestMapping(value="/queryDormByDormNum",method=RequestMethod.POST)
	public String queryDormByDormNum(HttpServletRequest request,HttpServletResponse response){
		String dorm_num = request.getParameter("dorm_num");
		if(dorm_num!=null){
			Dorm dorm =  dormServiceImpl.queryDormByDormNum(dorm_num);
			Map<String, Object> dataMap =  new Hashtable<>();
			if(dorm!=null){
				dataMap.put("dorm", dorm);
			}else{
				dataMap.put("msg", "请输入正确宿舍号！");
			}

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
