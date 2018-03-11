package com.lyb.dms.service;

import java.util.List;

import org.apache.ibatis.annotations.Update;

import com.lyb.dms.domain.Student;

public interface IStudentService {
	void insertStudent(Student student);
	
	void deleteStudent(Integer student_id);
	
	void updateStudent(Student student);
	
	List<Student> queryAllStudents();
	
	Student queryStudentById(Integer student_id);
	
	
	Student queryStudentByStudentNum(String StudentNum);
}
