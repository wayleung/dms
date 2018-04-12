package com.lyb.dms.service;

import java.util.List;
import java.util.Map;

import com.lyb.dms.domain.Dorm;

public interface IDormService {
	void insertDorm(Dorm dorm);
	
	void deleteDorm(Integer dorm_id);
	
	void updateDorm(Dorm dorm);
	
	List<Dorm> queryAllDorms();
	
	Dorm queryDormById(Integer dorm_id);

	Dorm queryDormByDormNum(String dorm_num);

	Integer queryCapicityByDormId(Integer dormId);
	
	List<Dorm> queryDormsCapicityOverTwo();
	
	List<Dorm>  queryBoyDormsCapicityOverTwo();
	
	List<Dorm>  queryGirlDormsCapicityOverTwo();
	
}
