package com.lyb.dms.mapper;

import com.lyb.dms.domain.DormStudent;
import com.lyb.dms.domain.DormStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DormStudentMapper {
    int countByExample(DormStudentExample example);

    int deleteByExample(DormStudentExample example);

    int deleteByPrimaryKey(Integer dsId);

    int insert(DormStudent record);

    int insertSelective(DormStudent record);

    List<DormStudent> selectByExample(DormStudentExample example);

    DormStudent selectByPrimaryKey(Integer dsId);

    int updateByExampleSelective(@Param("record") DormStudent record, @Param("example") DormStudentExample example);

    int updateByExample(@Param("record") DormStudent record, @Param("example") DormStudentExample example);

    int updateByPrimaryKeySelective(DormStudent record);

    int updateByPrimaryKey(DormStudent record);
}