package com.lyb.dms.service;

import java.util.List;


import com.lyb.dms.domain.DormStudent;

public interface IDormStudentService {
	void insertDormStudent(DormStudent dormStudent);
	
	void deleteDormStudent(Integer ds_id);
	
	void updateDormStudent(DormStudent dormStudent);
	
	List<DormStudent> queryAllDormStudents();
	
	DormStudent queryDormStudentById(Integer ds_id);
	
	
	List<DormStudent> checkStatus(Integer dm_id);

	DormStudent queryDormStudentByStudentId(Integer StudentId);

	List<DormStudent> queryDormStudentByDormId(Integer dormId);

	Integer queryCountNowByDormId(Integer dormId);
}
