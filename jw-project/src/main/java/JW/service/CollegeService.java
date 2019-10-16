package JW.service;

import java.util.List;

import org.springframework.ui.Model;

import JW.pojo.TCollege;
import pojo.EasyUIDataGridResult;
import utils.E3Result;

/**
 * Created by Administrator on 2017/6/17.
 */
public interface CollegeService {

	public E3Result delete(String ids);

	public void edit(TCollege college);

	public List<TCollege> findListNostatus();

	public EasyUIDataGridResult pageQuery(int page, int rows);

	public void save(TCollege model);

}
