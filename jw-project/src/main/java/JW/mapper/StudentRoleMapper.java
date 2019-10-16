package JW.mapper;

import JW.pojo.StudentRoleExample;
import JW.pojo.StudentRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentRoleMapper {
    int countByExample(StudentRoleExample example);

    int deleteByExample(StudentRoleExample example);

    int deleteByPrimaryKey(StudentRoleKey key);

    int insert(StudentRoleKey record);

    int insertSelective(StudentRoleKey record);

    List<StudentRoleKey> selectByExample(StudentRoleExample example);

    int updateByExampleSelective(@Param("record") StudentRoleKey record, @Param("example") StudentRoleExample example);

    int updateByExample(@Param("record") StudentRoleKey record, @Param("example") StudentRoleExample example);
}