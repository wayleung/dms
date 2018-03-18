package com.lyb.dms.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyb.dms.domain.Dorm;
import com.lyb.dms.domain.DormExample;
import com.lyb.dms.mapper.DormMapper;
import com.lyb.dms.service.IDormService;

@Service
public class DormServiceImpl implements IDormService {

	@Resource
	DormMapper dormMapper;
	
	@Override
	public void insertDorm(Dorm dorm) {
		// TODO Auto-generated method stub
		dormMapper.insertSelective(dorm);
	}

	@Override
	public void deleteDorm(Integer dorm_id) {
		// TODO Auto-generated method stub
		dormMapper.deleteByPrimaryKey(dorm_id);
	}

	@Override
	public void updateDorm(Dorm dorm) {
		// TODO Auto-generated method stub
		dormMapper.updateByPrimaryKeySelective(dorm);
	}

	@Override
	public List<Dorm> queryAllDorms() {
		DormExample example = new DormExample();
		// TODO Auto-generated method stub
		return dormMapper.selectByExample(example );
	}

	@Override
	public Dorm queryDormById(Integer dorm_id) {
		// TODO Auto-generated method stub
		return dormMapper.selectByPrimaryKey(dorm_id);
	}

}
