package JW.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import JW.mapper.TScoreMapper;
import JW.pojo.TScore;
import JW.pojo.TScoreExample;
import JW.pojo.TStudent;
import JW.pojo.TStudentExample;
import JW.pojo.TScoreExample.Criteria;
import JW.pojo.TScoreKey;
import JW.service.ScoreService;
import pojo.EasyUIDataGridResult;

import java.util.List;

/**
 * FINDSTUDENTNID
 */
@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private TScoreMapper scoreMapper;

	/**
	 * 添加成绩
	 */
	@Override
	public void save(TScore model) {
		scoreMapper.insert(model);
	}

	@Override
	public List<TScore> findStudent(String id) {
		List<TScore> list = scoreMapper.findStudentId(id);
		return list;
	}

	@Override
	public List<TScore> findById(String studentId) {
		List<TScore> list = scoreMapper.findStudentId(studentId);
		return list;
	}

	@Override
	public void saveScore(TScore model) {
		scoreMapper.updateByPrimaryKey(model);
	}
	
	/**
	 * ADDSTUDENTSCOREPAGEHELPERINFODATAGRID
	 */
	@Override
	public List<TScore> findAllCourseByStudentId(String sid) {
		List<TScore> list = scoreMapper.findAllCourseByStudentId(sid);
		return list;
	}
	/**
	 * COURSESTUDENTID
	 */
	@Override
	public EasyUIDataGridResult addScore(Integer page, Integer rows, String id) {
		PageHelper.startPage(page, rows);
		List<TScore> list = scoreMapper.addStudentScore(id);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		PageInfo<TScore> info = new PageInfo<>(list);
		result.setTotal(info.getTotal());
		return result;
	}
	/**
	 * STUDENTSCOREF
	 */
	@Override
	public List<TScore> findStudentExit(String sid, String ids) {
		List<TScore> list = scoreMapper.findCourseStudentId(sid, ids);
		return list;
	}
	/**
	 * 创建对象,对象赋值循环UPDATE
	 *
	 */
	@Override
	public List<TScore> findStudentScore(String sid) {
		List<TScore> list = scoreMapper.findStudentScore(sid);
		return list;
	}

	@Override
	public void addAbsent(String[] lateStudentId,String cid) {
		TScore record = new TScore();
		record.setCourseId(cid);
		for(String studentid : lateStudentId){
			record.setStudentId(studentid);
			TScore score = scoreMapper.selectByPrimaryKey(record);
			String absent = score.getAbsent();
			int times = Integer.valueOf(absent)+1;
			score.setAbsent(String.valueOf(times));
			scoreMapper.updateByPrimaryKey(score);
		}
	}
}
