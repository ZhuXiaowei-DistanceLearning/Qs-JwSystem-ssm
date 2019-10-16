package JW.mapper;

import JW.pojo.TStudent;
import JW.pojo.TStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TStudentMapper {
	int countByExample(TStudentExample example);

	int deleteByExample(TStudentExample example);

	int deleteByPrimaryKey(String sid);

	int insert(TStudent record);

	int insertSelective(TStudent record);

	List<TStudent> selectByExample(TStudentExample example);

	List<TStudent> findAll(String cid);

	TStudent selectByPrimaryKey(String sid);

	int updateByExampleSelective(@Param("record") TStudent record, @Param("example") TStudentExample example);

	int updateByExample(@Param("record") TStudent record, @Param("example") TStudentExample example);

	int updateByPrimaryKeySelective(TStudent record);

	int updateByPrimaryKey(TStudent record);
}