package JW.mapper;

import JW.pojo.TeacherRoleExample;
import JW.pojo.TeacherRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherRoleMapper {
    int countByExample(TeacherRoleExample example);

    int deleteByExample(TeacherRoleExample example);

    int deleteByPrimaryKey(TeacherRoleKey key);

    int insert(TeacherRoleKey record);

    int insertSelective(TeacherRoleKey record);

    List<TeacherRoleKey> selectByExample(TeacherRoleExample example);

    int updateByExampleSelective(@Param("record") TeacherRoleKey record, @Param("example") TeacherRoleExample example);

    int updateByExample(@Param("record") TeacherRoleKey record, @Param("example") TeacherRoleExample example);
}