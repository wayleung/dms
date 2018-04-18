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

import com.github.pagehelper.PageInfo;
import com.lyb.dms.domain.Fee;
import com.lyb.dms.serviceImpl.DormServiceImpl;
import com.lyb.dms.serviceImpl.FeeServiceImpl;
import com.lyb.dms.vo.QueryByPageObject;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/dms")
public class FeeController {

	@Resource
	private FeeServiceImpl feeServiceImpl;
	
	
	@Resource
	private DormServiceImpl dormServiceImpl;
	
	
	@RequestMapping(value="/insertFee",method=RequestMethod.POST)
	public String insertFee(HttpServletRequest request,HttpServletResponse response){
		String dormNum = request.getParameter("dormNum");
		String electricityFee = request.getParameter("electricityFee");
		String waterFee = request.getParameter("waterFee");
		String payTime = request.getParameter("payTime");
		String endTime = request.getParameter("endTime");
		String createTime = request.getParameter("createTime");
		String status = request.getParameter("status");
		String remark = request.getParameter("remark");
		Fee fee = new Fee();
		fee.setDormNum(dormNum);
		fee.setElectricityFee(electricityFee);
		fee.setWaterFee(waterFee);
		fee.setPayTime(payTime);
		fee.setEndTime(endTime);
		fee.setCreateTime(createTime);
		fee.setStatus(status);
		fee.setRemark(remark);
		

			
			if(dormServiceImpl.queryDormByDormNum(dormNum)==null){
				Map<String, Object> dataMap =  new Hashtable<>();
				dataMap.put("msg_insert", "该宿舍号不存在！");
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
				feeServiceImpl.insertFee(fee);
			}
			

		
		
		return null;
	}
	
	@RequestMapping(value="/deleteFee",method=RequestMethod.POST)
	public String deleteFee(HttpServletRequest request,HttpServletResponse response){
		String id_string = request.getParameter("id");
		if(id_string!=null){
			Integer id =  Integer.parseInt(id_string);
			feeServiceImpl.deleteFee(id);
			return null;
		}else{
			return null;
		}
	}
	
	@RequestMapping(value="/updateFee",method=RequestMethod.POST)
	public String updateFee(HttpServletRequest request,HttpServletResponse response){
		String id_string = request.getParameter("fId_update");
		String dormNum = request.getParameter("dormNum_update");
		String electricityFee = request.getParameter("electricityFee_update");
		String waterFee = request.getParameter("waterFee_update");
		String payTime = request.getParameter("payTime_update");
		String endTime = request.getParameter("endTime_update");
		String createTime = request.getParameter("createTime_update");
		String status = request.getParameter("status_update");
		String remark = request.getParameter("remark_update");
		Fee fee = new Fee();
		if(id_string!=null&&!id_string.equals("")){
			Integer id = Integer.parseInt(id_string);
			fee.setfId(id);
		}
		fee.setDormNum(dormNum);
		fee.setElectricityFee(electricityFee);
		fee.setWaterFee(waterFee);
		fee.setPayTime(payTime);

		fee.setEndTime(endTime);
		fee.setCreateTime(createTime);
		fee.setStatus(status);
		fee.setRemark(remark);
		feeServiceImpl.updateFee(fee);
		return null;
	}
	
/*	@RequestMapping(value="/queryAllFees",method=RequestMethod.POST)
	public String queryAllFees(HttpServletRequest request,HttpServletResponse response){
		List<Fee> list =  feeServiceImpl.queryAllFees();
		Map<String, List<Fee>> dataMap =  new HashMap<>();
		dataMap.put("feeList", list);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(dataMap);
		try {
			response.getWriter().write(jsonObject.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/
	
	
	@RequestMapping(value="/queryAllFees",method=RequestMethod.GET)
	public String queryAllFees(HttpServletRequest request,HttpServletResponse response,QueryByPageObject queryObject){
		
		PageInfo<Fee> list = feeServiceImpl.queryAllFeesByPage(queryObject);
		
		Map<String, PageInfo<Fee>> dataMap =  new HashMap<>();
		dataMap.put("feeList", list);
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
	
	
	@RequestMapping(value="/queryFeeById",method=RequestMethod.POST)
	public String queryFeeById(HttpServletRequest request,HttpServletResponse response){
		String id_string = request.getParameter("id");
		if(id_string!=null){
			Integer id =  Integer.parseInt(id_string);
			Fee fee =  feeServiceImpl.queryFeeById(id);
			Map<String, Fee> dataMap =  new Hashtable<>();
			dataMap.put("fee", fee);
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
	
	
	@RequestMapping(value="/queryFeeByDormNum",method=RequestMethod.POST)
	public String queryFeeByDormNum(HttpServletRequest request,HttpServletResponse response){
		String dorm_num = request.getParameter("dorm_num");
		if(dorm_num!=null){
			List<Fee> list =  feeServiceImpl.queryFeeByDormNum(dorm_num);
			Map<String, Object> dataMap =  new Hashtable<>();
			if(list!=null){
				dataMap.put("feeList", list);
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
