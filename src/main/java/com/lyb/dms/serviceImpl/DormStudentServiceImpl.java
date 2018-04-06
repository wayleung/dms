package com.lyb.dms.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyb.dms.domain.Dorm;
import com.lyb.dms.domain.DormExample;
import com.lyb.dms.domain.DormManager;
import com.lyb.dms.domain.DormStudent;
import com.lyb.dms.domain.DormStudentExample;
import com.lyb.dms.domain.DormStudentExample.Criteria;
import com.lyb.dms.domain.Student;
import com.lyb.dms.mapper.DormMapper;
import com.lyb.dms.mapper.DormStudentMapper;
import com.lyb.dms.service.IDormStudentService;

@Service
public class DormStudentServiceImpl implements IDormStudentService {
	@Resource
	DormStudentMapper dormStudentMapper;
	
	@Resource
	DormMapper dormMapper;
	
	@Override
	public void insertDormStudent(DormStudent dormStudent) {
		// TODO Auto-generated method stub
		dormStudentMapper.insertSelective(dormStudent);
	}

	@Override
	public void deleteDormStudent(Integer ds_id) {
		// TODO Auto-generated method stub
		dormStudentMapper.deleteByPrimaryKey(ds_id);
	}

	@Override
	public void updateDormStudent(DormStudent dormStudent) {
		// TODO Auto-generated method stub
		dormStudentMapper.updateByPrimaryKeySelective(dormStudent);
	}

	@Override
	public List<DormStudent> queryAllDormStudents() {
		DormStudentExample example =  new DormStudentExample();
		return dormStudentMapper.selectByExample(example);
		// TODO Auto-generated method stub

	}

	@Override
	public DormStudent queryDormStudentById(Integer ds_id) {
		return dormStudentMapper.selectByPrimaryKey(ds_id);
		// TODO Auto-generated method stub

	}
	
	
	@Override
	public DormStudent queryDormStudentByStudentId(Integer StudentId){
		DormStudentExample example = new DormStudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentIdEqualTo(StudentId);
		List<DormStudent> list = dormStudentMapper.selectByExample(example);
		// TODO Auto-generated method stub
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}

	}
	
	
	
	
	
	
	@Override
	public List<DormStudent> queryDormStudentByDormId(Integer dormId){
		DormStudentExample example = new DormStudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andDormIdEqualTo(dormId);
		List<DormStudent> list = dormStudentMapper.selectByExample(example);
		// TODO Auto-generated method stub
		if(list!=null&&list.size()>0){
			return list;
		}else{
			return null;
		}

	}
	
	
	
	@Override
	public Integer queryCountNowByDormId(Integer dormId){
		DormStudentExample example = new DormStudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andDormIdEqualTo(dormId);
		List<DormStudent> list = dormStudentMapper.selectByExample(example);
		// TODO Auto-generated method stub
		if(list!=null&&list.size()>0){
			return list.size();
		}else{
			return 0;
		}

	}
	
	

	@Override
	public List<DormStudent> checkStatus(Integer dm_id) {
		// TODO Auto-generated method stub
		DormStudentExample example =  new DormStudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andDormIdEqualTo(dm_id);
		return dormStudentMapper.selectByExample(example);
	}

	@Override
	public Integer distributeByTwoStudent(Integer StudentId1, Integer StudentId2, Integer dormId) {
		// TODO Auto-generated method stub
		DormStudent dormStudent1 = new DormStudent();
		dormStudent1.setDormId(dormId);
		dormStudent1.setStudentId(StudentId1);
		dormStudent1.setCreateTime(new Date().toString());
		dormStudent1.setRemark("自动分配");
		int st1 = dormStudentMapper.insertSelective(dormStudent1 );
		
		
		
		
		DormStudent dormStudent2 = new DormStudent();
		dormStudent2.setDormId(dormId);
		dormStudent2.setStudentId(StudentId2);
		dormStudent2.setCreateTime(new Date().toString());
		dormStudent2.setRemark("自动分配");
		int st2 = dormStudentMapper.insertSelective(dormStudent2 );
		
		
		if(st1==1&&st2==0){
			
			//只插入学生1
			return 1;
		}else if(st1==0&&st2==1){
			
			//只插入学生2
			return 2;
		}else if(st1==1&&st2==1){
			//插入学生1 2
			return 12;
		}else{
			
			//插入失败
			return 0;
		}
	}





	
	
}
