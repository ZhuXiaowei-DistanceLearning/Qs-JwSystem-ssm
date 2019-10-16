package JW.mapper;

import JW.pojo.TTeacher;
import JW.pojo.TTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTeacherMapper {
	int countByExample(TTeacherExample example);

	int deleteByExample(TTeacherExample example);

	int deleteByPrimaryKey(String tid);

	int insert(TTeacher record);

	int insertSelective(TTeacher record);

	List<TTeacher> selectByExample(TTeacherExample example);

	TTeacher selectByPrimaryKey(String tid);

	int updateByExampleSelective(@Param("record") TTeacher record, @Param("example") TTeacherExample example);

	int updateByExample(@Param("record") TTeacher record, @Param("example") TTeacherExample example);

	int updateByPrimaryKeySelective(TTeacher record);

	int updateByPrimaryKey(TTeacher record);

	List<TTeacher> findAll();
}