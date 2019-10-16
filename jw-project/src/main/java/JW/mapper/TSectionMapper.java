package JW.mapper;

import JW.pojo.TSection;
import JW.pojo.TSectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSectionMapper {
    int countByExample(TSectionExample example);

    int deleteByExample(TSectionExample example);

    int deleteByPrimaryKey(String id);

    int insert(TSection record);

    int insertSelective(TSection record);

    List<TSection> selectByExample(TSectionExample example);

    TSection selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TSection record, @Param("example") TSectionExample example);

    int updateByExample(@Param("record") TSection record, @Param("example") TSectionExample example);

    int updateByPrimaryKeySelective(TSection record);

    int updateByPrimaryKey(TSection record);
}