package com.lyb.dms.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.lyb.dms.domain.Fee;
import com.lyb.dms.vo.QueryByPageObject;


public interface IFeeService {
	void insertFee(Fee fee);
	
	void deleteFee(Integer fee_id);
	
	void updateFee(Fee fee);
	
	List<Fee> queryAllFees();
	
	PageInfo<Fee> queryAllFeesByPage(QueryByPageObject queryObject);
	
	Fee queryFeeById(Integer fee_id);
	
	List<Fee> queryFeeByDormNum(String dormNum);
}
