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

import com.github.pagehelper.PageInfo;
import com.lyb.dms.domain.Dorm;
import com.lyb.dms.domain.DormStudent;
import com.lyb.dms.domain.Fee;
import com.lyb.dms.domain.Student;
import com.lyb.dms.service.IStudentService;
import com.lyb.dms.serviceImpl.DormServiceImpl;
import com.lyb.dms.serviceImpl.DormStudentServiceImpl;
import com.lyb.dms.serviceImpl.FeeServiceImpl;
import com.lyb.dms.serviceImpl.StudentServiceImpl;
import com.lyb.dms.vo.DormStudentVO;
import com.lyb.dms.vo.QueryByPageObject;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/dms")
public class StudentController {

	@Resource
	private StudentServiceImpl studentServiceImpl;
	
	@Resource
	private DormStudentServiceImpl dormStudentServiceImpl;
	
	
	@Resource
	private DormServiceImpl dormServiceImpl;
	
	@Resource
	private FeeServiceImpl feeServiceImpl;
	
	
	@RequestMapping(value="/insertStudent",method=RequestMethod.POST)
	public String insertStudent(HttpServletRequest request,HttpServletResponse response){
		String studentNum = request.getParameter("studentNum");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		String sex = request.getParameter("sex");
		String state = request.getParameter("state");
		String location = request.getParameter("location");
		String phone = request.getParameter("phone");
		String studentClass = request.getParameter("studentClass");
		String major = request.getParameter("major");
		String getupTime = request.getParameter("getupTime");
		String sleepTime = request.getParameter("sleepTime");
		String hobby = request.getParameter("hobby");
		String habit = request.getParameter("habit");
		String emergencyContact = request.getParameter("emergencyContact");
		String emergencyPhone = request.getParameter("emergencyPhone");
		String remark = request.getParameter("remark");
		Student student = new Student();
		student.setStudentNum(studentNum);
		student.setPassword(password);
		student.setName(name);
		student.setBirthDate(birthDate);
		student.setSex(sex);
		student.setState(state);
		student.setLocation(location);
		student.setPhone(phone);
		student.setStudentClass(studentClass);
		student.setMajor(major);
		student.setGetupTime(getupTime);
		student.setSleepTime(sleepTime);
		student.setHobby(hobby);
		student.setHabit(habit);
		student.setEmergencyContact(emergencyContact);
		student.setEmergencyPhone(emergencyPhone);
		student.setRemark(remark);
		
		if(studentServiceImpl.queryStudentByStudentNum(studentNum)!=null){
			Map<String, Object> dataMap =  new Hashtable<>();
			dataMap.put("msg_insert", "该学号已经存在！");
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
			studentServiceImpl.insertStudent(student);
		}
		
		
		return null;
	}
	
	@RequestMapping(value="/deleteStudent",method=RequestMethod.POST)
	public String deleteStudent(HttpServletRequest request,HttpServletResponse response){
		String id_string = request.getParameter("id");
		if(id_string!=null){
			Integer id =  Integer.parseInt(id_string);
			studentServiceImpl.deleteStudent(id);
			return null;
		}else{
			return null;
		}
	}
	
	@RequestMapping(value="/updateStudent",method=RequestMethod.POST)
	public String updateStudent(HttpServletRequest request,HttpServletResponse response){
		String id_string = request.getParameter("id");
		String studentNum = request.getParameter("studentNum");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		String sex = request.getParameter("sex");
		String state = request.getParameter("state");
		String location = request.getParameter("location");
		String phone = request.getParameter("phone");
		String studentClass = request.getParameter("studentClass");
		String major = request.getParameter("major");
		String getupTime = request.getParameter("getupTime");
		String sleepTime = request.getParameter("sleepTime");
		String hobby = request.getParameter("hobby");
		String habit = request.getParameter("habit");
		String emergencyContact = request.getParameter("emergencyContact");
		String emergencyPhone = request.getParameter("emergencyPhone");
		String remark = request.getParameter("remark");
		Student student = new Student();
		student.setStudentNum(studentNum);
		student.setPassword(password);
		student.setName(name);
		student.setBirthDate(birthDate);
		student.setSex(sex);
		student.setState(state);
		student.setLocation(location);
		student.setPhone(phone);
		student.setStudentClass(studentClass);
		student.setMajor(major);
		student.setGetupTime(getupTime);
		student.setSleepTime(sleepTime);
		student.setHobby(hobby);
		student.setHabit(habit);
		student.setEmergencyContact(emergencyContact);
		student.setEmergencyPhone(emergencyPhone);
		student.setRemark(remark);
		if(id_string!=null&&!id_string.equals("")){
			Integer id = Integer.parseInt(id_string);
			student.setStudentId(id);
		}
		
		studentServiceImpl.updateStudent(student);
		return null;
	}
	
/*	@RequestMapping(value="/queryAllStudents",method=RequestMethod.POST)
	public String queryAllStudents(HttpServletRequest request,HttpServletResponse response){
		List<Student> list =  studentServiceImpl.queryAllStudents();
		Map<String, List<Student>> dataMap =  new HashMap<>();
		dataMap.put("studentList", list);
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
	
	
	@RequestMapping(value="/queryAllStudents",method=RequestMethod.GET)
	public String queryAllStudents(HttpServletRequest request,HttpServletResponse response,QueryByPageObject queryObject){
		
		//List<Student> list =  studentServiceImpl.queryAllStudents();
		PageInfo<Student> list = studentServiceImpl.queryAllStudentsByPage(queryObject);
		//Map<String, List<Student>> dataMap =  new HashMap<>();
		Map<String, PageInfo<Student>> dataMap =  new HashMap<>();
		dataMap.put("studentList", list);
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
	
	@RequestMapping(value="/queryStudentById",method=RequestMethod.POST)
	public String queryStudentById(HttpServletRequest request,HttpServletResponse response){
		String id_string = request.getParameter("id");
		if(id_string!=null){
			Integer id =  Integer.parseInt(id_string);
			Student student =  studentServiceImpl.queryStudentById(id);
			Map<String, Student> dataMap =  new Hashtable<>();
			dataMap.put("student", student);
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
	
	
	
	@RequestMapping(value="/queryStudentByStudentNum",method=RequestMethod.POST)
	public String queryStudentByStudentNum(HttpServletRequest request,HttpServletResponse response){
		String studentNum = request.getParameter("studentNum");
		if(studentNum!=null){
			Student student =  studentServiceImpl.queryStudentByStudentNum(studentNum);
			Map<String, Object> dataMap =  new Hashtable<>();
			if(student!=null){
				dataMap.put("student", student);
			}else{
				dataMap.put("msg", "请输入正确学号！");
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
	
	
	
	
	
	@RequestMapping(value="/queryMyInfoFromSession",method=RequestMethod.POST)
	public String queryMyInfoById(HttpServletRequest request,HttpServletResponse response){
		Integer id = (Integer) request.getSession().getAttribute("studentId");
		if(id!=null){
			Student student =  studentServiceImpl.queryStudentById(id);
			Map<String, Student> dataMap =  new Hashtable<>();
			dataMap.put("student", student);
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
	
	
	
	
	
	@RequestMapping(value="/checkDistribute",method=RequestMethod.POST)
	public String checkDistribute(HttpServletRequest request,HttpServletResponse response){
		String stu_id = String.valueOf( request.getSession().getAttribute("studentId"));
		Integer StudentId = Integer.parseInt(stu_id);
		DormStudent dormStudentByStudentId = dormStudentServiceImpl.queryDormStudentByStudentId(StudentId );
		if(dormStudentByStudentId==null){
			Map<String, Object> dataMap =  new Hashtable<>();
			dataMap.put("msg","您还没被分配宿舍，请联系宿管！");
			dataMap.put("success",0);
			JSONObject jsonObject = new JSONObject();
			jsonObject.putAll(dataMap);
			try {
				response.getWriter().write(jsonObject.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			Integer dormId = dormStudentByStudentId.getDormId();
				List<DormStudent> volist = dormStudentServiceImpl.checkStatus(dormId);
				List<DormStudentVO>  dormStudentVOList = new ArrayList<>();
				for (DormStudent dormStudent : volist) {
					Integer studentId =  dormStudent.getStudentId();
					
				    String studentName = studentServiceImpl.queryStudentById(studentId).getName();
				    
				    String studentNum = studentServiceImpl.queryStudentById(studentId).getStudentNum();
				    
				    
				    String dormNum =  dormServiceImpl.queryDormById(dormId).getDormNum();
				    
				    Integer capacity =  dormServiceImpl.queryDormById(dormId).getCapacity();

				    Integer headId = dormServiceImpl.queryDormById(dormId).getHeadId();
				    
				    DormStudentVO dormStudentVO = new DormStudentVO();
				    dormStudentVO.setDsId(dormStudent.getDsId());
				    	dormStudentVO.setCapacity(capacity);

				    
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
				    if(StringUtils.isNotBlank(studentName)){
				    	dormStudentVO.setStudentName(studentName);
				    }
				    dormStudentVO.setStudentNum(studentNum);
				    
				    dormStudentVO.setStudentId(studentId);
				    
				    dormStudentVOList.add(dormStudentVO);
				}
				
				
				
				
				Map<String, Object> dataMap =  new Hashtable<>();
				dataMap.put("dormStudentVOList",dormStudentVOList );
				dataMap.put("msg","查看成功");
				dataMap.put("success",1);
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
	
	
	
	@RequestMapping(value="/checkFee",method=RequestMethod.POST)
	public String checkFee(HttpServletRequest request,HttpServletResponse response){
		String stu_id = String.valueOf( request.getSession().getAttribute("studentId"));
		Integer StudentId = Integer.parseInt(stu_id);
		DormStudent dormStudent = dormStudentServiceImpl.queryDormStudentByStudentId(StudentId);
		if(dormStudent==null){

			Map<String, Object> dataMap =  new Hashtable<>();
			dataMap.put("success", 0);
			dataMap.put("msg", "您还没分配宿舍，没有水电费缴费消息");
			JSONObject jsonObject = new JSONObject();
			jsonObject.putAll(dataMap);
			try {
				response.getWriter().write(jsonObject.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			Integer dormId = dormStudent.getDormId();
			Dorm dorm = dormServiceImpl.queryDormById(dormId);
			String dorm_num = dorm.getDormNum();
			if(StringUtils.isNotBlank(dorm_num)){
				List<Fee> list =  feeServiceImpl.queryFeeByDormNum(dorm_num);
				Map<String, Object> dataMap =  new Hashtable<>();
				if(list!=null){
					dataMap.put("success", 1);
					dataMap.put("msg", "查询成功");
					dataMap.put("feeList", list);
				}else{
					dataMap.put("success", 0);
					dataMap.put("msg", "没有缴费消息");
				}

				JSONObject jsonObject = new JSONObject();
				jsonObject.putAll(dataMap);
				try {
					response.getWriter().write(jsonObject.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		return null;
	}
}
