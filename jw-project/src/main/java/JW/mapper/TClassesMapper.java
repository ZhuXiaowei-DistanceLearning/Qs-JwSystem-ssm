package JW.mapper;

import JW.pojo.TClasses;
import JW.pojo.TClassesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TClassesMapper {
    int countByExample(TClassesExample example);

    int deleteByExample(TClassesExample example);

    int deleteByPrimaryKey(String id);

    int insert(TClasses record);

    int insertSelective(TClasses record);

    List<TClasses> selectByExample(TClassesExample example);

    TClasses selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TClasses record, @Param("example") TClassesExample example);

    int updateByExample(@Param("record") TClasses record, @Param("example") TClassesExample example);

    int updateByPrimaryKeySelective(TClasses record);

    int updateByPrimaryKey(TClasses record);
    
    List<TClasses> findAll();
}