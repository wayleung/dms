package com.lyb.dms.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyb.dms.domain.Fee;
import com.lyb.dms.domain.FeeExample;
import com.lyb.dms.domain.Student;
import com.lyb.dms.domain.StudentExample;
import com.lyb.dms.domain.FeeExample.Criteria;
import com.lyb.dms.mapper.FeeMapper;
import com.lyb.dms.service.IFeeService;
import com.lyb.dms.vo.QueryByPageObject;

@Service
public class FeeServiceImpl implements IFeeService {
	
	@Resource
	private FeeMapper feeMapper;
	

	@Override
	public void insertFee(Fee fee) {
		Date now = new Date();
		SimpleDateFormat smf = new SimpleDateFormat("MM/dd/yyyy");
		String date = smf.format(now);
		// TODO Auto-generated method stub
		fee.setCreateTime(date);
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

	@Override
	public PageInfo<Fee> queryAllFeesByPage(QueryByPageObject queryObject) {
		// TODO Auto-generated method stub
		FeeExample example = new FeeExample();
		PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
		//pagehelper不是内存分页是物理分页 PageHelper只对紧跟着的第一个SQL语句起作用
		List<Fee> list = feeMapper.selectByExample(example);
		PageInfo<Fee> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
