package com.lyb.dms.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Update;

import com.lyb.dms.domain.Student;

public interface IStudentService {
	void insertStudent(Student student);
	
	void deleteStudent(Integer student_id);
	
	void updateStudent(Student student);
	
	List<Student> queryAllStudents();
	
	List<Student> queryAllBoyStudents();
		
	List<Student> queryAllGirlStudents();
	
	
	Student queryStudentById(Integer student_id);
	
	
	Student queryStudentByStudentNum(String StudentNum);
	
	Map<String, Object> studentLogin(String StudentNum,String password);
}
