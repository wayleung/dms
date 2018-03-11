package com.lyb.dms.controller;

import java.io.IOException;
import java.util.ArrayList;
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

import com.lyb.dms.domain.DormStudent;
import com.lyb.dms.serviceImpl.DormServiceImpl;
import com.lyb.dms.serviceImpl.DormStudentServiceImpl;
import com.lyb.dms.serviceImpl.StudentServiceImpl;
import com.lyb.dms.vo.DormStudentVO;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/dms")
public class DormStudentController {

	@Resource
	private DormStudentServiceImpl dormStudentServiceImpl;
	
	
	@Resource
	private DormServiceImpl dormServiceImpl;
	
	
	@Resource
	private StudentServiceImpl studentServiceImpl;
	
	
	@RequestMapping(value="/insertDormStudent",method=RequestMethod.POST)
	public String insertDormStudent(HttpServletRequest request,HttpServletResponse response){
		String studentId = request.getParameter("studentId");
		String dormId = request.getParameter("dormId");
		String joinTime = request.getParameter("joinTime");
		String leaveTime = request.getParameter("leaveTime");
		String leaveReason = request.getParameter("leaveReason");
		String createTime = request.getParameter("createTime");
		String remark = request.getParameter("remark");
		DormStudent dormStudent = new DormStudent();
		
		if(studentId!=null&&!studentId.equals("")){
			Integer student_id = Integer.parseInt(studentId);
			dormStudent.setStudentId(student_id);
		}
		if(dormId!=null&&!dormId.equals("")){
			Integer dorm_id = Integer.parseInt(dormId);
			dormStudent.setDormId(dorm_id);
		}
		dormStudent.setJoinTime(joinTime);
		dormStudent.setLeaveTime(leaveTime);
		dormStudent.setLeaveReason(leaveReason);
		dormStudent.setCreateTime(createTime);
		dormStudent.setRemark(remark);
		dormStudentServiceImpl.insertDormStudent(dormStudent);
		return null;
	}
	
	@RequestMapping(value="/deleteDormStudent",method=RequestMethod.POST)
	public String deleteDormStudent(HttpServletRequest request,HttpServletResponse response){
		String id_string = request.getParameter("id");
		if(id_string!=null){
			Integer id =  Integer.parseInt(id_string);
			dormStudentServiceImpl.deleteDormStudent(id);
			return null;
		}else{
			return null;
		}
	}
	
	@RequestMapping(value="/updateDormStudent",method=RequestMethod.POST)
	public String updateDormStudent(HttpServletRequest request,HttpServletResponse response){
		String id_string = request.getParameter("id_update");
		String studentId = request.getParameter("studentId_update");
		String dormId = request.getParameter("dormId_update");
		String joinTime = request.getParameter("joinTime_update");
		String leaveTime = request.getParameter("leaveTime_update");
		String leaveReason = request.getParameter("leaveReason_update");
		String createTime = request.getParameter("createTime_update");
		String remark = request.getParameter("remark");
		DormStudent dormStudent = new DormStudent();
		
		if(studentId!=null&&!studentId.equals("")){
			Integer student_id = Integer.parseInt(studentId);
			dormStudent.setStudentId(student_id);
		}
		if(dormId!=null&&!dormId.equals("")){
			Integer dorm_id = Integer.parseInt(dormId);
			dormStudent.setDormId(dorm_id);
		}
		dormStudent.setJoinTime(joinTime);
		dormStudent.setLeaveTime(leaveTime);
		dormStudent.setLeaveReason(leaveReason);
		dormStudent.setCreateTime(createTime);
		dormStudent.setRemark(remark);
		
		if(id_string!=null&&!id_string.equals("")){
			Integer id = Integer.parseInt(id_string);
			dormStudent.setDsId(id);
		}
		
		
		dormStudentServiceImpl.updateDormStudent(dormStudent);
		return null;
	}
	
	@RequestMapping(value="/queryAllDormStudents",method=RequestMethod.POST)
	public String queryAllDormStudents(HttpServletRequest request,HttpServletResponse response){
		List<DormStudent> list =  dormStudentServiceImpl.queryAllDormStudents();
		Map<String, List<DormStudent>> dataMap =  new HashMap<>();
		dataMap.put("dormStudentList", list);
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
	
	@RequestMapping(value="/queryDormStudentById",method=RequestMethod.POST)
	public String queryDormStudentById(HttpServletRequest request,HttpServletResponse response){
		String id_string = request.getParameter("id");
		if(id_string!=null){
			Integer id =  Integer.parseInt(id_string);
			DormStudent dormStudent =  dormStudentServiceImpl.queryDormStudentById(id);
			Map<String, DormStudent> dataMap =  new Hashtable<>();
			dataMap.put("dormStudent", dormStudent);
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


	
	@RequestMapping(value="/checkStatus",method=RequestMethod.POST)
	public String checkStatus(HttpServletRequest request,HttpServletResponse response){
		String id_string = request.getParameter("id");
		if(id_string!=null){
			Integer dormId =  Integer.parseInt(id_string);
			List<DormStudent> volist = dormStudentServiceImpl.checkStatus(dormId);
			List<DormStudentVO>  dormStudentVOList = new ArrayList<>();
			for (DormStudent dormStudent : volist) {
				Integer studentId =  dormStudent.getStudentId();
				
			    String studenName = studentServiceImpl.queryStudentById(studentId).getName();
			    
			    String studenNum = studentServiceImpl.queryStudentById(studentId).getStudentNum();
			    
			    
			    String dormNum =  dormServiceImpl.queryDormById(dormId).getDormNum();
			    
			    String capacity =  dormServiceImpl.queryDormById(dormId).getCapacity();

			    Integer headId = dormServiceImpl.queryDormById(dormId).getHeadId();
			    
			    DormStudentVO dormStudentVO = new DormStudentVO();
			    dormStudentVO.setDsId(dormStudent.getDsId());
			    if(StringUtils.isNotBlank(capacity)){
			    	dormStudentVO.setCapacity(capacity);
			    }
			    
			    if(StringUtils.isNotBlank(dormStudent.getCreateTime())){
			    	dormStudentVO.setCreateTime(dormStudent.getCreateTime());
			    }
			    
			    
			    dormStudentVO.setDormId(dormId);
			    
			    if(StringUtils.isNotBlank(dormNum)){
			    	dormStudentVO.setDormNum(dormNum);
			    }
			    
			    dormStudentVO.setHeadId(headId);
			    
			    if(StringUtils.isNotBlank(dormStudent.getJoinTime())){
			    	dormStudentVO.setJoinTime(dormStudent.getJoinTime());
			    }
			    
			    
			    
			    if(StringUtils.isNotBlank(dormStudent.getLeaveReason())){
			    	dormStudentVO.setLeaveReason(dormStudent.getLeaveReason());
			    }
			    
			    if(StringUtils.isNotBlank(dormStudent.getLeaveTime())){
			    	dormStudentVO.setLeaveTime(dormStudent.getLeaveTime());
			    }
			    if(StringUtils.isNotBlank(dormStudent.getRemark())){
			    	dormStudentVO.setRemark(dormStudent.getRemark());
			    }
			    if(StringUtils.isNotBlank(studenName)){
			    	dormStudentVO.setStudenName(studenName);
			    }
			    dormStudentVO.setStudenNum(studenNum);
			    
			    dormStudentVO.setStudentId(studentId);
			    
			    dormStudentVOList.add(dormStudentVO);
			}
			
			
			
			
			Map<String, List<DormStudentVO>> dataMap =  new Hashtable<>();
			dataMap.put("dormStudentVOList",dormStudentVOList );
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
	
	
	@RequestMapping(value="/distribute",method=RequestMethod.POST)
	public String distribute(HttpServletRequest request,HttpServletResponse response){
		String studentNum= request.getParameter("studentNum");
		
		DormStudent dormStudent = new DormStudent();
		String dorm_Id = request.getParameter("dormId");
		if(StringUtils.isNotBlank(dorm_Id)){
			dormStudent.setDormId(Integer.parseInt(dorm_Id));
		}
		
		String joinTime = request.getParameter("joinTime");
		String remark = request.getParameter("remark");
		
		Integer studentId = studentServiceImpl.queryStudentByStudentNum(studentNum).getStudentId();
	
		dormStudent.setStudentId(studentId);
		dormStudent.setJoinTime(joinTime);
		dormStudent.setRemark(remark);
		dormStudentServiceImpl.insertDormStudent(dormStudent);
		return null;
	}
	
}
