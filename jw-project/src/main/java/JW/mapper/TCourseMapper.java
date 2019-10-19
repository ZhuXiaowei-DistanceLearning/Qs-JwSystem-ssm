package JW.mapper;

import JW.pojo.TCourse;
import JW.pojo.TCourseExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TCourseMapper {
    int countByExample(TCourseExample example);

    int deleteByExample(TCourseExample example);

    int deleteByPrimaryKey(String id);

    int insert(TCourse record);

    int insertSelective(TCourse record);

    List<TCourse> selectByExample(TCourseExample example);

    TCourse selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TCourse record, @Param("example") TCourseExample example);

    int updateByExample(@Param("record") TCourse record, @Param("example") TCourseExample example);

    int updateByPrimaryKeySelective(TCourse record);

    int updateByPrimaryKey(TCourse record);

    List<TCourse> findAll();

    List<TCourse> findCourseByteacherId(String tid);

    void updateByCoursePeople(TCourse course);
}