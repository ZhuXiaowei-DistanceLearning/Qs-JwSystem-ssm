package JW.service.impl;

import JW.mapper.AuthFunctionMapper;
import JW.pojo.AuthFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import JW.mapper.AuthRoleMapper;
import JW.pojo.AuthRole;
import JW.pojo.AuthRoleExample;
import JW.service.RoleSerivce;
import pojo.EasyUIDataGridResult;

import javax.annotation.Resource;
import java.util.List;

/**
 * 插入对象ID是数组
 * 中间表插入值INSERTFUNCTION
 */
@Service
public class RoleServiceImpl implements RoleSerivce {

    @Autowired
    private AuthRoleMapper roleMapper;
    @Autowired
    private AuthFunctionMapper functionMapper;

    /**
     * EXAMPLE
     */
    @Override
    public void save(AuthRole model, String ids) {
        roleMapper.insert(model);
        String[] id = ids.split(",");
        for (String functionId : id) {
            roleMapper.RoleinsertFunction(model.getId(), functionId);
        }
    }

    @Override
    public void update(String ids, String roleId) {
        List<String> list = roleMapper.queryFunctionByRole(roleId);
        for (int i = 0; i < list.size(); i++) {
            roleMapper.deleteRoleFunction(list.get(i));
        }
        String[] id = ids.split(",");
        for (String functionId : id) {
            roleMapper.insertFunction(roleId, functionId);
        }
    }

    /**
     * EXAMPLEPAGEHELPERINFODATAGRIDRESULT
     */
    @Override
    public List<AuthRole> findAll() {
        AuthRoleExample example = new AuthRoleExample();
        List<AuthRole> list = roleMapper.selectByExample(example);
        return list;
    }

    @Override
    public EasyUIDataGridResult pageQuery(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        AuthRoleExample example = new AuthRoleExample();
        List<AuthRole> list = roleMapper.selectByExample(example);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(list);
        PageInfo<AuthRole> info = new PageInfo<>(list);
        result.setTotal(info.getTotal());
        return result;
    }

    @Override
    public void deleteRole(String roleId) {
        roleMapper.deleteFunction(roleId);
        roleMapper.deleteRole(roleId);
    }
}
