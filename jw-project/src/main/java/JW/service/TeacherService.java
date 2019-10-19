package JW.service;

import java.util.List;

import JW.pojo.TStudent;
import JW.pojo.TTeacher;
import pojo.EasyUIDataGridResult;

/**
 * Created by Administrator on 2017/6/18.
 */
public interface TeacherService {

	public List<TTeacher> findListNoStatus();

	public void save(TTeacher model, String roleIds);

	public TTeacher findByUsername(String username);

	public EasyUIDataGridResult pageQuery(Integer page, Integer rows);

	List<TTeacher> findListNoStatusAndCollege(String id);
}
