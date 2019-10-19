package JW.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import JW.mapper.TTeacherMapper;
import JW.mapper.TeacherRoleMapper;
import JW.pojo.TTeacher;
import JW.pojo.TTeacherExample;
import JW.pojo.TUser;
import JW.pojo.TUserExample;
import JW.pojo.TUserExample.Criteria;
import JW.pojo.TeacherRoleKey;
import JW.service.TeacherService;
import pojo.EasyUIDataGridResult;

import java.util.List;

/**
 * EXAMPE判断状态值
 */
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TTeacherMapper teacherMapper;
	@Autowired
	private TeacherRoleMapper teacherRoleMapper;

	/**
	 * EXAMPLE判断用
	 * list集合空间
	 */
	@Override
	public List<TTeacher> findListNoStatus() {
		TTeacherExample example = new TTeacherExample();
		example.createCriteria().andStatusEqualTo("0");
		List<TTeacher> list = teacherMapper.selectByExample(example);
		return list;
	}
	
	/**
	 * 暂未使用的方法
	 * FINDALLPAGEHELPERINFODATAGRIDRESULT
	 */
	@Override
	public TTeacher findByUsername(String username) {
		TTeacherExample teacherExample = new TTeacherExample();
		JW.pojo.TTeacherExample.Criteria teacherCriteria = teacherExample.createCriteria();
		teacherCriteria.andTidEqualTo(username);
		List<TTeacher> teacher = teacherMapper.selectByExample(teacherExample);
		if (teacher.size() == 1) {
			return teacher.get(0);
		} else {
			return null;
		}
	}
	/**
	 * 插入对象，拆分数组id
	 * 用中间角色表插入数据
	 */
	@Override
	public EasyUIDataGridResult pageQuery(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<TTeacher> list = teacherMapper.findAll();
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		PageInfo<TTeacher> info = new PageInfo<>(list);
		result.setTotal(info.getTotal());
		return result;
	}

	@Override
	public List<TTeacher> findListNoStatusAndCollege(String id) {
		List<TTeacher> list = teacherMapper.findListNoStatusAndCollege(id);
		return list;
	}

	@Override
	public void save(TTeacher model, String roleIds) {
		teacherMapper.insert(model);
		String[] ids = roleIds.split(",");
		for (String id : ids) {
			TeacherRoleKey record = new TeacherRoleKey();
			record.setRoleId(id);
			record.setTeacherId(model.getTid());
			teacherRoleMapper.insert(record);
		}
	}
}
