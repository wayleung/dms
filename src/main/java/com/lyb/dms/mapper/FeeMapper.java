package com.lyb.dms.mapper;

import com.lyb.dms.domain.Fee;
import com.lyb.dms.domain.FeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeeMapper {
    int countByExample(FeeExample example);

    int deleteByExample(FeeExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(Fee record);

    int insertSelective(Fee record);

    List<Fee> selectByExample(FeeExample example);

    Fee selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") Fee record, @Param("example") FeeExample example);

    int updateByExample(@Param("record") Fee record, @Param("example") FeeExample example);

    int updateByPrimaryKeySelective(Fee record);

    int updateByPrimaryKey(Fee record);
}