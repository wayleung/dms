package com.lyb.dms.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.lyb.dms.domain.Dorm;
import com.lyb.dms.domain.DormStudent;
import com.lyb.dms.domain.Student;
import com.lyb.dms.vo.QueryByPageObject;

public interface IDormStudentService {
	void insertDormStudent(DormStudent dormStudent);
	
	void deleteDormStudent(Integer ds_id);
	
	void updateDormStudent(DormStudent dormStudent);
	
	List<DormStudent> queryAllDormStudents();
	
	PageInfo<DormStudent> queryAllDormStudentsByPage(QueryByPageObject queryObject);
	
	
	DormStudent queryDormStudentById(Integer ds_id);
	
	
	List<DormStudent> checkStatus(Integer dm_id);

	DormStudent queryDormStudentByStudentId(Integer StudentId);

	List<DormStudent> queryDormStudentByDormId(Integer dormId);

	Integer queryCountNowByDormId(Integer dormId);
	
	Integer distributeByTwoStudent(Integer StudentId1,Integer StudentId2,Integer dormId);

}
