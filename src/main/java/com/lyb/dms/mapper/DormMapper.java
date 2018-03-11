package com.lyb.dms.mapper;

import com.lyb.dms.domain.Dorm;
import com.lyb.dms.domain.DormExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DormMapper {
    int countByExample(DormExample example);

    int deleteByExample(DormExample example);

    int deleteByPrimaryKey(Integer dormId);

    int insert(Dorm record);

    int insertSelective(Dorm record);

    List<Dorm> selectByExample(DormExample example);

    Dorm selectByPrimaryKey(Integer dormId);

    int updateByExampleSelective(@Param("record") Dorm record, @Param("example") DormExample example);

    int updateByExample(@Param("record") Dorm record, @Param("example") DormExample example);

    int updateByPrimaryKeySelective(Dorm record);

    int updateByPrimaryKey(Dorm record);
}