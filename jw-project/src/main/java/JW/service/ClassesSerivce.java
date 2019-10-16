package JW.service;

import java.util.List;

import JW.pojo.TClasses;
import pojo.EasyUIDataGridResult;

/**
 * Created by Administrator on 2017/6/17.
 */
public interface ClassesSerivce {

	public EasyUIDataGridResult pageQuery(int page, int rows);

	public void save(TClasses model);

	public void deleteBatch(String ids);

	public TClasses findById(String id);

}
