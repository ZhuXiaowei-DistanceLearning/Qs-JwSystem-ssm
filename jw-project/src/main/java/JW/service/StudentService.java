package JW.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import JW.pojo.TStudent;
import pojo.EasyUIDataGridResult;
import utils.E3Result;

/**
 * Created by Administrator on 2017/6/17.
 */
public interface StudentService {
	public void saveBatch(List<TStudent> student);

	public List<TStudent> findAll();

	public E3Result addStudentAbenst(String[] studentIds);

	public TStudent findByUsername(String username);

	public EasyUIDataGridResult findStudentByclass(String ids, Integer page, Integer rows);

	public EasyUIDataGridResult pageQuery(Integer page, Integer rows);

	public String importXlsStudent(MultipartFile myFile, String cid, HttpServletResponse response);

	public void exportXlsStudent(HttpServletResponse response, HttpServletRequest request, String cid) throws Exception;

}
