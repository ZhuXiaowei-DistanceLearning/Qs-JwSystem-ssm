package JW.mapper;

import JW.pojo.TNature;
import JW.pojo.TNatureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TNatureMapper {
    int countByExample(TNatureExample example);

    int deleteByExample(TNatureExample example);

    int deleteByPrimaryKey(String id);

    int insert(TNature record);

    int insertSelective(TNature record);

    List<TNature> selectByExample(TNatureExample example);

    TNature selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TNature record, @Param("example") TNatureExample example);

    int updateByExample(@Param("record") TNature record, @Param("example") TNatureExample example);

    int updateByPrimaryKeySelective(TNature record);

    int updateByPrimaryKey(TNature record);
}