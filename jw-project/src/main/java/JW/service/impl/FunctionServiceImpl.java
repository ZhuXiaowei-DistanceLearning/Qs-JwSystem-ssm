package JW.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import JW.mapper.AuthFunctionMapperCustom;
import JW.mapper.AuthFunctionMapper;
import JW.mapper.TStudentMapper;
import JW.mapper.TTeacherMapper;
import JW.pojo.AuthFunction;
import JW.pojo.AuthFunctionExample;
import JW.pojo.TStudent;
import JW.pojo.TTeacher;
import JW.pojo.TUser;
import JW.service.FunctionService;
import pojo.EasyUIDataGridResult;

import java.security.Security;
import java.util.List;

/**
 * 判断对象属于的对象，查找对应的菜单
 */
@Service
public class FunctionServiceImpl implements FunctionService {
	@Autowired
	private AuthFunctionMapper functionMapper;
	@Autowired
	private AuthFunctionMapperCustom functionMapperCustom;
	@Autowired
	private TTeacherMapper teacherMapper;
	@Autowired
	private TStudentMapper studentMapper;
	
	/**
	 * findALL
	 */
	@Override
	public List<AuthFunction> findMenu() {
		Subject subject = SecurityUtils.getSubject();
		Object object = subject.getPrincipal();
		List<AuthFunction> list = null;
		if (object instanceof TUser) {
			list = functionMapperCustom.findMenuByUserid(((TUser) object).getId());
		} else if (object instanceof TTeacher) {
			list = functionMapperCustom.findMenuByTeacherid(((TTeacher) object).getTid());
		} else if (object instanceof TStudent) {
			list = functionMapperCustom.findMenuByStudentid(((TStudent) object).getSid());
		}
		return list;
	}

	@Override
	public List<AuthFunction> findAll() {
		List<AuthFunction> list = functionMapperCustom.findAll();
		return list;
	}

	/**
	 * FINDBYTEACHERID
	 */
	@Override
	public void save(AuthFunction model) {
		functionMapper.insert(model);
	}
	/**
	 * FINDBYSTUDENTTID
	 * 判断list值
	 */
	@Override
	public List<AuthFunction> findListByTeacherid(String tid) {
		List<AuthFunction> list = functionMapperCustom.findListByTeacherid(tid);
		if (list.size() != 0) {
			return list;
		}
		return null;
	}

	/**
	 * EXAMPLEPAGEHELPERINFODATAGRID
	 */
	@Override
	public List<AuthFunction> findListByStudentid(String sid) {
		List<AuthFunction> list = functionMapperCustom.findListByStudentid(sid);
		if (list.size() != 0) {
			return list;
		}
		return null;
	}

	@Override
	public EasyUIDataGridResult pageQuery(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		AuthFunctionExample example = new AuthFunctionExample();
		List<AuthFunction> list = functionMapper.selectByExample(example);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		PageInfo<AuthFunction> info = new PageInfo<>(list);
		result.setTotal(info.getTotal());
		return result;
	}
}
