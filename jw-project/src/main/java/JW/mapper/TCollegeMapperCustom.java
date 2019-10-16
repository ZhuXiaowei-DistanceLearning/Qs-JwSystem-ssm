package JW.mapper;

import JW.pojo.TCollege;
import JW.pojo.TCollegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCollegeMapperCustom {
	int deleteByStatus(String id);
}