package com.lyb.dms.service;

import java.util.List;

import com.lyb.dms.domain.DormManager;

public interface IDormManagerService {
	void insertDormManager(DormManager dormManager);
	
	void deleteDormManager(Integer dm_id);
	
	void updateDormManager(DormManager dormManager);
	
	List<DormManager> queryAllDormManagers();
	
	DormManager queryDormManagerById(Integer dm_id);

	DormManager queryDormManagerByDmNum(String dm_num);
}
