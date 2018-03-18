package com.lyb.dms.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
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
	
	
	@Override
	public Map<String, Object> studentLogin(String StudentNum,String password) {
	
		// TODO Auto-generated method stub
		Student student_select = queryStudentByStudentNum(StudentNum);
		if(StringUtils.isBlank(StudentNum)||StringUtils.isBlank(password)){
			//账户密码为空
			Map<String, Object> dataMap =  new HashMap<>();
			dataMap.put("msg","账户密码为空" );
			return dataMap;
		}
		
		
		if(student_select!=null){
			if(student_select.getPassword().equals(password)){
				//账号存在且密码正确
				Map<String, Object> dataMap =  new HashMap<>();
				dataMap.put("msg","登录成功" );
				dataMap.put("list",student_select );
				return dataMap;
			}else{
				//密码错误
				Map<String, Object> dataMap =  new HashMap<>();
				dataMap.put("msg","账号或密码不正确" );
				return dataMap;
			}
		}else{
			//账号不存在
			Map<String, Object> dataMap =  new HashMap<>();
			dataMap.put("msg","账号或密码不正确" );
			return dataMap;
		}
	
	}
	

}
