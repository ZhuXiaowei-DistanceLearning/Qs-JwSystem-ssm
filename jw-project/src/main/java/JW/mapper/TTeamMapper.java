package JW.mapper;

import JW.pojo.TTeam;
import JW.pojo.TTeamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTeamMapper {
    int countByExample(TTeamExample example);

    int deleteByExample(TTeamExample example);

    int deleteByPrimaryKey(String id);

    int insert(TTeam record);

    int insertSelective(TTeam record);

    List<TTeam> selectByExample(TTeamExample example);

    TTeam selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TTeam record, @Param("example") TTeamExample example);

    int updateByExample(@Param("record") TTeam record, @Param("example") TTeamExample example);

    int updateByPrimaryKeySelective(TTeam record);

    int updateByPrimaryKey(TTeam record);
}