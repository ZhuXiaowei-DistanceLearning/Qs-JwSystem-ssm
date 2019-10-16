package JW.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import JW.mapper.TCollegeMapper;
import JW.mapper.TCollegeMapperCustom;
import JW.pojo.TCollege;
import JW.pojo.TCollegeExample;
import JW.pojo.TCollegeExample.Criteria;
import JW.service.CollegeService;
import pojo.EasyUIDataGridResult;
import utils.E3Result;

import java.util.List;

/**
 * id是数组
 */
@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	private TCollegeMapper collegeMapper;
	@Autowired
	private TCollegeMapperCustom collegeMapperCustom;
	
	/**
	 * 先通过id查在更新
	 */
	@Override
	public E3Result delete(String ids) {
		String[] id = ids.split(",");
		for (String string : id) {
			collegeMapperCustom.deleteByStatus(string);
		}
		return E3Result.ok(200);
	}
	
	/**
	 * example
	 */
	@Override
	public void edit(TCollege college) {
		TCollege collegeEdit = collegeMapper.selectByPrimaryKey(college.getId());
		collegeEdit.setName(college.getName());
		collegeEdit.setStatus(college.getStatus());
		collegeMapper.updateByPrimaryKey(collegeEdit);
	}

	/**
	 * EXAMPLE:
	 * PAEGHelpInfoDATAGRID
	 */
	@Override
	public List<TCollege> findListNostatus() {
		TCollegeExample example = new TCollegeExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusNotEqualTo("1");
		List<TCollege> list = collegeMapper.selectByExample(example);
		return list;
	}

	@Override
	public EasyUIDataGridResult pageQuery(int page, int rows) {
		PageHelper.startPage(page, rows);
		TCollegeExample example = new TCollegeExample();
		List<TCollege> list = collegeMapper.selectByExample(example);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		PageInfo<TCollege> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		result.setTotal(total);
		return result;
	}

	@Override
	public void save(TCollege model) {
		collegeMapper.insertSelective(model);
	}
}
