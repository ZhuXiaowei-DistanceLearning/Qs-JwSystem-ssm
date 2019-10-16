package JW.service.impl;

import JW.mapper.TClassesMapper;
import JW.pojo.TClasses;
import JW.pojo.TClassesExample;
import JW.pojo.TCollege;
import JW.pojo.TCollegeExample;
import JW.service.ClassesSerivce;
import pojo.EasyUIDataGridResult;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 */
@Service
@Transactional
public class ClassesSerivceImpl implements ClassesSerivce {
	@Autowired
	private TClassesMapper classesMapper;
	/**
	 * 数组id
	 */
	@Override
	public void save(TClasses model) {
		classesMapper.insert(model);
	}
	
	/**
	 * 
	 * FINDALLPAGEINFOHELPER
	 */
	@Override
	public TClasses findById(String id) {
		String[] split = id.split(",");
		for (String ids : split) {
			return classesMapper.selectByPrimaryKey(id);
		}
		return null;
	}

	@Override
	public EasyUIDataGridResult pageQuery(int page, int rows) {
		PageHelper.startPage(page, rows);
		List<TClasses> list = classesMapper.findAll();
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		PageInfo<TClasses> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		result.setTotal(total);
		return result;
	}

	/**
	 * DATAGRIDRESULT
	 * PAGEINFO
	 */
	@Override
	public void deleteBatch(String ids) {
		classesMapper.deleteByPrimaryKey(ids);
	}
}
