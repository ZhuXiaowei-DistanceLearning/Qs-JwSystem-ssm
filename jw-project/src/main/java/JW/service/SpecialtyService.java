package JW.service;

import java.util.List;

import org.springframework.ui.Model;

import JW.pojo.TSpecialty;
import pojo.EasyUIDataGridResult;

/**
 * Created by Administrator on 2017/6/17.
 */
public interface SpecialtyService {
	public void add(TSpecialty specialty);

	public void update(TSpecialty model);

	public void deleteBatch(String id);

	public List<TSpecialty> listajax(String id);

	public EasyUIDataGridResult pageQuery(int page, int rows);

	public void redoSpecialty(String id);

}
