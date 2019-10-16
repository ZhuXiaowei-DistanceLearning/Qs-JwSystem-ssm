package JW.service;

import java.util.List;

import JW.pojo.TCourse;
import pojo.EasyUIDataGridResult;

/**
 * Created by Administrator on 2017/6/18.
 */
public interface CourseService {
	public void add(TCourse model);

	public TCourse findById(String courseid);

	public EasyUIDataGridResult pageQuery(Integer page, Integer rows);

	public EasyUIDataGridResult findCourseByteacherId(Integer page, Integer rows, String tid);

	void addPeople(int i, String id);
}
