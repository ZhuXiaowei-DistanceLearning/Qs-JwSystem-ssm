package JW.mapper;

import JW.pojo.TScore;
import JW.pojo.TScoreExample;
import JW.pojo.TScoreKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TScoreMapper {
	int countByExample(TScoreExample example);

	int deleteByExample(TScoreExample example);

	int deleteByPrimaryKey(TScoreKey key);

	int insert(TScore record);

	int insertSelective(TScore record);

	List<TScore> selectByExample(TScoreExample example);

	List<TScore> findStudentId(String ids);

	List<TScore> findCourseStudentId(String id, String ids);

	List<TScore> findAllCourseByStudentId(String ids);

	List<TScore> findStudentScore(String ids);

	List<TScore> addStudentScore(String courseId);

	TScore selectByPrimaryKey(TScoreKey key);

	int updateByExampleSelective(@Param("record") TScore record, @Param("example") TScoreExample example);

	int updateByExample(@Param("record") TScore record, @Param("example") TScoreExample example);

	int updateByPrimaryKeySelective(TScore record);

	int updateByPrimaryKey(TScore record);
}