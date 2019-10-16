package JW.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import JW.pojo.TStudent;
import JW.service.StudentService;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import pojo.EasyUIDataGridResult;
import utils.E3Result;
import utils.FileUtils;
import utils.XssfUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class StudentAction {

	@Autowired
	private StudentService studentService;

	/**
	 * 导出学生信息模板模板
	 */
	@RequestMapping("/exportXlsModel")
	public void ExportXlsModel(HttpServletResponse response, HttpServletRequest request) throws Exception {
		XssfUtils xfu = new XssfUtils();
		xfu.ExportXlsModel(request, response);
	}

	@RequestMapping("/exportXlsStudent")
	public void ExportXlsStudent(HttpServletResponse response, HttpServletRequest request, String cid)
			throws Exception {
		studentService.exportXlsStudent(response, request, cid);
	}

	@RequestMapping("/importXlsStudent")
	@ResponseBody
	public String ImportXlsStudent(@RequestParam("myFile") MultipartFile myFile, String cid,
			HttpServletResponse response) throws Exception {
		String flag = studentService.importXlsStudent(myFile, cid, response);
		return flag;
	}

	@RequestMapping("/pageQuery")
	@ResponseBody
	public EasyUIDataGridResult pageQuery(Integer page, Integer rows) throws IOException {
		EasyUIDataGridResult result = studentService.pageQuery(page, rows);
		return null;
	}

	@RequestMapping("/findStudentByclass")
	@ResponseBody
	public EasyUIDataGridResult findStudentByclass(Integer page, Integer rows, HttpSession session) throws IOException {
		String id = (String) session.getAttribute("classes_id");
		EasyUIDataGridResult result = studentService.findStudentByclass(id, page, rows);
		return result;
	}
	
	/**
	 * 获取subject
	 * 设置attribute返回
	 * @param lateStudentId
	 * @return
	 */
	@RequestMapping("/addStudentAbsent")
	public E3Result addAbsent(String[] lateStudentId) {
		E3Result result = studentService.addStudentAbenst(lateStudentId);
		return result;
	}

	@RequestMapping("/PersonScorePage")
	public String PersonScorePage(HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		TStudent student = (TStudent) subject.getPrincipal();
		request.setAttribute("PersonStudent", student);
		return "/student/PersonScore";
	}
}
