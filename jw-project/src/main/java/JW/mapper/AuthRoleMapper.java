package JW.mapper;

import JW.pojo.AuthFunction;
import JW.pojo.AuthRole;
import JW.pojo.AuthRoleExample;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

    List<String> queryFunctionByRole(String roleId);

    @Delete("delete from role_function where function_id = #{id}")
    void deleteRoleFunction(@Param("id") String id);

    @Insert("insert into role_function values(#{functionId},#{roleId})")
    void insertFunction(@Param("functionId") String functionId, @Param("roleId") String roleId);

    @Delete("delete from auth_role where id = #{roleId}")
    void deleteRole(@Param("roleId") String roleId);

    @Delete("delete from role_function where role_id = #{roleId}")
    void deleteFunction(@Param("roleId") String roleId);
}