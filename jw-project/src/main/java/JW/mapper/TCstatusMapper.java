package JW.mapper;

import JW.pojo.TCstatus;
import JW.pojo.TCstatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCstatusMapper {
    int countByExample(TCstatusExample example);

    int deleteByExample(TCstatusExample example);

    int deleteByPrimaryKey(String id);

    int insert(TCstatus record);

    int insertSelective(TCstatus record);

    List<TCstatus> selectByExample(TCstatusExample example);

    TCstatus selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TCstatus record, @Param("example") TCstatusExample example);

    int updateByExample(@Param("record") TCstatus record, @Param("example") TCstatusExample example);

    int updateByPrimaryKeySelective(TCstatus record);

    int updateByPrimaryKey(TCstatus record);
}