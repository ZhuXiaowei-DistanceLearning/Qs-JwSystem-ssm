package JW.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import JW.pojo.TClasses;
import JW.service.ClassesSerivce;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import pojo.EasyUIDataGridResult;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/classes")
public class ClassesAction {
	@Autowired
	private ClassesSerivce classesSerivce;

	/**
	 * 分页查询
	 *
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/pageQuery")
	@ResponseBody
	public EasyUIDataGridResult pageQuery(Integer page, Integer rows) throws IOException {
		EasyUIDataGridResult result = classesSerivce.pageQuery(page, rows);
		return result;
	}

	@RequestMapping("/add")
	public String add(TClasses model) {
		classesSerivce.save(model);
		return "/base/classes";
	}

	@RequestMapping("/delete")
	public String delete(String ids) {
		classesSerivce.deleteBatch(ids);
		return "/base/classes";
	}

	@RequestMapping("/findById")
	public String findById(String ids, HttpSession session) {
		session.setAttribute("classes_id", ids);
		return "/base/studentInfo";
	}

	/**
	 * 查询列表
	 */
	public String listajax() throws IOException {
		return null;
		/*
		 * List<College> list = collegeService.findListNostatus();
		 * this.writeList2Json(list, new String[] { "teachers", "specialties"
		 * }); return NONE;
		 */
	}

	@RequestMapping("/page")
	public String page() {
		return "/base/classes";
	}
}
