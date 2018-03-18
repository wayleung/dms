package com.lyb.dms.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyb.dms.domain.DormManager;
import com.lyb.dms.domain.DormStudent;
import com.lyb.dms.domain.DormStudentExample;
import com.lyb.dms.domain.DormStudentExample.Criteria;
import com.lyb.dms.mapper.DormStudentMapper;
import com.lyb.dms.service.IDormStudentService;

@Service
public class DormStudentServiceImpl implements IDormStudentService {
	@Resource
	DormStudentMapper dormStudentMapper;
	
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
	public List<DormStudent> checkStatus(Integer dm_id) {
		// TODO Auto-generated method stub
		DormStudentExample example =  new DormStudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andDormIdEqualTo(dm_id);
		return dormStudentMapper.selectByExample(example);
	}

	
	
}
