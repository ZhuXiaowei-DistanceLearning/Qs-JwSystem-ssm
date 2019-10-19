package JW.mapper;

import JW.pojo.TExamway;
import JW.pojo.TExamwayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TExamwayMapper {
    int countByExample(TExamwayExample example);

    int deleteByExample(TExamwayExample example);

    int deleteByPrimaryKey(String id);

    int insert(TExamway record);

    int insertSelective(TExamway record);

    List<TExamway> selectByExample(TExamwayExample example);

    TExamway selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TExamway record, @Param("example") TExamwayExample example);

    int updateByExample(@Param("record") TExamway record, @Param("example") TExamwayExample example);

    int updateByPrimaryKeySelective(TExamway record);

    int updateByPrimaryKey(TExamway record);
}