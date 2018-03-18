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

import com.lyb.dms.domain.Student;
import com.lyb.dms.service.IStudentService;
import com.lyb.dms.serviceImpl.StudentServiceImpl;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/dms")
public class StudentController {

	@Resource
	private StudentServiceImpl studentServiceImpl;
	
	
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
		studentServiceImpl.insertStudent(student);
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
		System.out.println(id_string);
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
	
	@RequestMapping(value="/queryAllStudents",method=RequestMethod.POST)
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
}
