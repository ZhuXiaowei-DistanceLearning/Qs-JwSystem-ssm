package JW.mapper;

import JW.pojo.TSpecialty;
import JW.pojo.TSpecialtyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSpecialtyMapper {
    int countByExample(TSpecialtyExample example);

    int deleteByExample(TSpecialtyExample example);

    int deleteByPrimaryKey(String id);

    int insert(TSpecialty record);

    int insertSelective(TSpecialty record);

    List<TSpecialty> selectByExample(TSpecialtyExample example);

    TSpecialty selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TSpecialty record, @Param("example") TSpecialtyExample example);

    int updateByExample(@Param("record") TSpecialty record, @Param("example") TSpecialtyExample example);

    int updateByPrimaryKeySelective(TSpecialty record);

    int updateByPrimaryKey(TSpecialty record);
    
    int deleteBatch(String id);
    
    List<TSpecialty> findAll();
}