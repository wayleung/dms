package com.lyb.dms.service;

import java.util.List;

import com.lyb.dms.domain.Dorm;

public interface IDormService {
	void insertDorm(Dorm dorm);
	
	void deleteDorm(Integer dorm_id);
	
	void updateDorm(Dorm dorm);
	
	List<Dorm> queryAllDorms();
	
	Dorm queryDormById(Integer dorm_id);
	
}
