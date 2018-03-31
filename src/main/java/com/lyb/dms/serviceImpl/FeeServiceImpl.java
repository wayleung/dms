package com.lyb.dms.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyb.dms.domain.Fee;
import com.lyb.dms.domain.FeeExample;
import com.lyb.dms.domain.FeeExample.Criteria;
import com.lyb.dms.mapper.FeeMapper;
import com.lyb.dms.service.IFeeService;

@Service
public class FeeServiceImpl implements IFeeService {
	
	@Resource
	private FeeMapper feeMapper;
	

	@Override
	public void insertFee(Fee fee) {
		// TODO Auto-generated method stub
		feeMapper.insertSelective(fee);
	}

	@Override
	public void deleteFee(Integer fee_id) {
		// TODO Auto-generated method stub
		feeMapper.deleteByPrimaryKey(fee_id);
	}

	@Override
	public void updateFee(Fee fee) {
		// TODO Auto-generated method stub
		feeMapper.updateByPrimaryKeySelective(fee);
	}

	@Override
	public List<Fee> queryAllFees() {
		FeeExample example = new FeeExample();
		// TODO Auto-generated method stub
		return feeMapper.selectByExample(example);
	}

	@Override
	public Fee queryFeeById(Integer fee_id) {
		// TODO Auto-generated method stub
		return feeMapper.selectByPrimaryKey(fee_id);
	}

	@Override
	public List<Fee> queryFeeByDormNum(String dormNum) {
		// TODO Auto-generated method stub
		FeeExample example = new FeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andDormNumEqualTo(dormNum);
		// TODO Auto-generated method stub
		List<Fee> list = feeMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list;	
		}else{
			return null;
		}

		
	}

}
