package com.lyb.dms.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyb.dms.domain.DormManager;
import com.lyb.dms.domain.DormManagerExample;
import com.lyb.dms.mapper.DormManagerMapper;
import com.lyb.dms.service.IDormManagerService;

@Service
public class DormManagerServiceImpl implements IDormManagerService {

	@Resource
	DormManagerMapper dormManagerMapper;
	
	@Override
	public void insertDormManager(DormManager dormManager) {
		// TODO Auto-generated method stub
		dormManagerMapper.insert(dormManager);
	}

	@Override
	public void deleteDormManager(Integer dm_id) {
		// TODO Auto-generated method stub
		dormManagerMapper.deleteByPrimaryKey(dm_id);
	}

	@Override
	public void updateDormManager(DormManager dormManager) {
		// TODO Auto-generated method stub
		dormManagerMapper.updateByPrimaryKeySelective(dormManager);
	}

	@Override
	public List<DormManager> queryAllDormManagers() {
		DormManagerExample example = new DormManagerExample();
		return dormManagerMapper.selectByExample(example );
		// TODO Auto-generated method stub

	}

	@Override
	public DormManager queryDormManagerById(Integer dm_id) {
		return dormManagerMapper.selectByPrimaryKey(dm_id);
		// TODO Auto-generated method stub

	}

}
