package com.lyb.dms.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.lyb.dms.domain.Dorm;
import com.lyb.dms.domain.DormExample;
import com.lyb.dms.domain.DormExample.Criteria;
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
	
	
	@Override
	public Dorm queryDormByDormNum(String dorm_num) {
		if(StringUtils.isBlank(dorm_num)){
			return null;
		}
		DormExample example = new DormExample();
		Criteria criteria = example.createCriteria();
		criteria.andDormNumEqualTo(dorm_num);
		// TODO Auto-generated method stub
		List<Dorm> list = dormMapper.selectByExample(example );
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
		
	}
	
	@Override
	public Integer queryCapicityByDormId(Integer dormId) {
		if(dormId==null){
			return 0;
		}
		DormExample example = new DormExample();
		Criteria criteria = example.createCriteria();
		criteria.andDormIdEqualTo(dormId);
		// TODO Auto-generated method stub
		List<Dorm> list = dormMapper.selectByExample(example );
		if(list!=null&&list.size()>0){
			String capacity = list.get(0).getCapacity();
			Integer capacity_int = Integer.parseInt(capacity);
			if(capacity_int>=0){
				return capacity_int;
			}else{
				return 0;
			}
		}else{
			return 0;
		}
		
	}
	
	
	
	

}
