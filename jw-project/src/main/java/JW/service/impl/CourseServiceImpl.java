package JW.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import JW.mapper.TCourseMapper;
import JW.pojo.TCourse;
import JW.service.CourseService;
import pojo.EasyUIDataGridResult;

/**
 * 
 * 设置对象IID
 */
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private TCourseMapper courseMapper;

	@Override
	public void addPeople(int i, String id) {
		TCourse course = new TCourse();
		course.setPeople(i);
		course.setId(id);
		courseMapper.updateByCoursePeople(course);
	}

	/**
	 * 
	 * FINDALLPAGEHELPERINFODATAGRID
	 */
	@Override
	public TCourse findById(String courseid) {
		TCourse course = courseMapper.selectByPrimaryKey(courseid);
		return course;
	}
	
	/**
	 * 
	 * FINCOURSEBYTEACHERPAGEHELPERINFODATAGRID
	 */
	@Override
	public EasyUIDataGridResult pageQuery(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<TCourse> list = courseMapper.findAll();
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		PageInfo<TCourse> info = new PageInfo<>(list);
		long total = info.getTotal();
		result.setTotal(total);
		return result;
	}

	
	@Override
	public EasyUIDataGridResult findCourseByteacherId(Integer page, Integer rows, String tid) {
		PageHelper.startPage(page, rows);
		List<TCourse> list = courseMapper.findCourseByteacherId(tid);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		PageInfo<TCourse> info = new PageInfo<>(list);
		long total = info.getTotal();
		result.setTotal(total);
		return result;
	}

	@Override
	public void add(TCourse model) {
		courseMapper.insert(model);
	}

}
