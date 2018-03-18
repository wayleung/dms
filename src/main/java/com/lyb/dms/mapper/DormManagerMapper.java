package com.lyb.dms.mapper;

import com.lyb.dms.domain.DormManager;
import com.lyb.dms.domain.DormManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DormManagerMapper {
    int countByExample(DormManagerExample example);

    int deleteByExample(DormManagerExample example);

    int deleteByPrimaryKey(Integer dmId);

    int insert(DormManager record);

    int insertSelective(DormManager record);

    List<DormManager> selectByExample(DormManagerExample example);

    DormManager selectByPrimaryKey(Integer dmId);

    int updateByExampleSelective(@Param("record") DormManager record, @Param("example") DormManagerExample example);

    int updateByExample(@Param("record") DormManager record, @Param("example") DormManagerExample example);

    int updateByPrimaryKeySelective(DormManager record);

    int updateByPrimaryKey(DormManager record);
}