package JW.service.impl;

import JW.pojo.TCollege;
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
	 *
	 */
	@Override
	public List<TSpecialty> listajax(String id) {
		TSpecialtyExample example = new TSpecialtyExample();
		example.createCriteria().andCollegeIdEqualTo(id);
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

	@Override
	public void redoSpecialty(String id) {
		TSpecialty tCollege = specialtyMapper.selectByPrimaryKey(id);
		if (tCollege.getStatus().equals("1")) {
			tCollege.setStatus("0");
			specialtyMapper.updateByPrimaryKey(tCollege);
		}
	}

}
