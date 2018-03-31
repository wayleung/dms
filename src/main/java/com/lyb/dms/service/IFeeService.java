package com.lyb.dms.service;

import java.util.List;
import java.util.Map;

import com.lyb.dms.domain.Fee;


public interface IFeeService {
	void insertFee(Fee fee);
	
	void deleteFee(Integer fee_id);
	
	void updateFee(Fee fee);
	
	List<Fee> queryAllFees();
	
	Fee queryFeeById(Integer fee_id);
	
	List<Fee> queryFeeByDormNum(String dormNum);
}
