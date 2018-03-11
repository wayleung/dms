package com.lyb.dms.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyb.dms.domain.Student;
import com.lyb.dms.domain.StudentExample;
import com.lyb.dms.domain.StudentExample.Criteria;
import com.lyb.dms.mapper.StudentMapper;
import com.lyb.dms.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Resource
	private StudentMapper studentMapper;
	
	@Override
	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
		studentMapper.insertSelective(student);
	}

	@Override
	public void deleteStudent(Integer student_id) {
		// TODO Auto-generated method stub
		studentMapper.deleteByPrimaryKey(student_id);
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		studentMapper.updateByPrimaryKeySelective(student);
	}

	@Override
	public List<Student> queryAllStudents() {
		StudentExample example = new StudentExample();
		return studentMapper.selectByExample(example );
	}

	@Override
	public Student queryStudentById(Integer student_id) {
		return studentMapper.selectByPrimaryKey(student_id);

	}

	@Override
	public Student queryStudentByStudentNum(String  StudentNum) {
		// TODO Auto-generated method stub
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentNumEqualTo(StudentNum);
		List<Student> list = studentMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	
	

}
