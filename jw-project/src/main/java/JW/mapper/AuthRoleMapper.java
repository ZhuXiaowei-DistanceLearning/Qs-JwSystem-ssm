package JW.mapper;

import JW.pojo.AuthRole;
import JW.pojo.AuthRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.directwebremoting.annotations.Auth;

public interface AuthRoleMapper {
	int countByExample(AuthRoleExample example);

	int deleteByExample(AuthRoleExample example);

	int deleteByPrimaryKey(String id);

	int insert(AuthRole record);

	int insertSelective(AuthRole record);

	int RoleinsertFunction(String roleId, String functionId);

	List<AuthRole> selectByExample(AuthRoleExample example);

	AuthRole selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") AuthRole record, @Param("example") AuthRoleExample example);

	int updateByExample(@Param("record") AuthRole record, @Param("example") AuthRoleExample example);

	int updateByPrimaryKeySelective(AuthRole record);

	int updateByPrimaryKey(AuthRole record);

	List<AuthRole> findAll();
}