package JW.service;

import JW.pojo.AuthRole;
import pojo.EasyUIDataGridResult;

import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 */
public interface RoleSerivce {
	public void save(AuthRole model, String ids);

	public void update(String ids, String roleId);

	public List<AuthRole> findAll();

	public EasyUIDataGridResult pageQuery(Integer page, Integer rows);

	void deleteRole(String roleId);
}
