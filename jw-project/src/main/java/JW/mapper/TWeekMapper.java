package JW.mapper;

import JW.pojo.TWeek;
import JW.pojo.TWeekExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TWeekMapper {
    int countByExample(TWeekExample example);

    int deleteByExample(TWeekExample example);

    int deleteByPrimaryKey(String id);

    int insert(TWeek record);

    int insertSelective(TWeek record);

    List<TWeek> selectByExample(TWeekExample example);

    TWeek selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TWeek record, @Param("example") TWeekExample example);

    int updateByExample(@Param("record") TWeek record, @Param("example") TWeekExample example);

    int updateByPrimaryKeySelective(TWeek record);

    int updateByPrimaryKey(TWeek record);
}