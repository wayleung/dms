package com.lyb.dms.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyb.dms.domain.Dorm;
import com.lyb.dms.domain.DormManager;
import com.lyb.dms.domain.DormManagerExample;
import com.lyb.dms.domain.DormManagerExample.Criteria;
import com.lyb.dms.mapper.DormManagerMapper;
import com.lyb.dms.service.IDormManagerService;
import com.lyb.dms.vo.QueryByPageObject;

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
	
	
	
	@Override
	public DormManager queryDormManagerByDmNum(String dm_num) {
		
		DormManagerExample example = new DormManagerExample();
		Criteria criteria = example.createCriteria();
		criteria.andDmNumEqualTo(dm_num);
		List<DormManager> list = dormManagerMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
		// TODO Auto-generated method stub

	}

	@Override
	public PageInfo<DormManager> queryAllDormManagersByPage(QueryByPageObject queryObject) {
		// TODO Auto-generated method stub
		
		
		DormManagerExample example = new DormManagerExample();
		PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
		//pagehelper不是内存分页是物理分页 PageHelper只对紧跟着的第一个SQL语句起作用
		List<DormManager> list = dormManagerMapper.selectByExample(example );
		PageInfo<DormManager> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
