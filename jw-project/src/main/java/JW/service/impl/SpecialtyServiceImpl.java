package JW.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import JW.mapper.TSpecialtyMapper;
import JW.pojo.TSpecialty;
import JW.pojo.TSpecialtyExample;
import JW.pojo.TSpecialtyExample.Criteria;
import JW.service.SpecialtyService;
import pojo.EasyUIDataGridResult;

import java.util.List;

/**
 * 数组id
 * pageHelp
 * pageInfo
 * DATAResult
 */
@Service
public class SpecialtyServiceImpl implements SpecialtyService {

	@Autowired
	private TSpecialtyMapper specialtyMapper;

	@Override
	public void add(TSpecialty model) {
		specialtyMapper.insert(model);
	}

	/**
	 * 数组id
	 */
	@Override
	public void update(TSpecialty model) {
		specialtyMapper.updateByPrimaryKey(model);
	}
	
	/**
	 * example
	 */
	@Override
	public void deleteBatch(String ids) {
		String[] id = ids.split(",");
		for (String spId : id) {
			specialtyMapper.deleteBatch(spId);
		}
	}

	/**
	 * FINDALLPAGEHELPINFODATAGRIDRESULT
	 */
	@Override
	public List<TSpecialty> listajax() {
		TSpecialtyExample example = new TSpecialtyExample();
		List<TSpecialty> list = specialtyMapper.selectByExample(example);
		return list;
	}
	
	@Override
	public EasyUIDataGridResult pageQuery(int page, int rows) {
		PageHelper.startPage(page, rows);
		List<TSpecialty> list = specialtyMapper.findAll();
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		PageInfo<TSpecialty> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		result.setTotal(total);
		return result;
	}

}
