package com.lyb.dms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lyb.dms.domain.DormManager;
import com.lyb.dms.vo.QueryByPageObject;

public interface IDormManagerService {
	void insertDormManager(DormManager dormManager);
	
	void deleteDormManager(Integer dm_id);
	
	void updateDormManager(DormManager dormManager);
	
	List<DormManager> queryAllDormManagers();
	
	PageInfo<DormManager> queryAllDormManagersByPage(QueryByPageObject queryObject);
	
	
	DormManager queryDormManagerById(Integer dm_id);

	DormManager queryDormManagerByDmNum(String dm_num);
}
