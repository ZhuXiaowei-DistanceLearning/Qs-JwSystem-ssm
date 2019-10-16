package JW.service;


import java.util.List;

import JW.pojo.TScore;
import pojo.EasyUIDataGridResult;

/**
 * Created by Administrator on 2017/6/20.
 */
public interface ScoreService {
    public void save(TScore model);

    public List<TScore> findStudent(String ids);


    public List<TScore> findById(String studentId);

    public void saveScore(TScore model);

    public List<TScore> findAllCourseByStudentId(String sid);

	public EasyUIDataGridResult addScore(Integer page, Integer rows, String id);

	public List<TScore> findStudentExit(String sid, String ids);

	public List<TScore> findStudentScore(String sid);

	public void addAbsent(String[] lateStudentId, String cid);

}
