package JW.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import JW.pojo.TTeacher;
import JW.service.TeacherService;
import pojo.EasyUIDataGridResult;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherAction {
	@Autowired
	private TeacherService teacherService;

	@RequestMapping("/pageQuery")
	@ResponseBody
	public EasyUIDataGridResult pageQuery(Integer page, Integer rows) throws IOException {
		EasyUIDataGridResult result = teacherService.pageQuery(page, rows);
		return result;
	}

	@RequestMapping("/listajax")
	@ResponseBody
	public List<TTeacher> listajax() throws IOException {
		List<TTeacher> list = teacherService.findListNoStatus();
		return list;
	}

	@RequestMapping("/teacherByCollege")
	@ResponseBody
	public List<TTeacher> teacherByCollege(String id) throws IOException {
		List<TTeacher> list = teacherService.findListNoStatusAndCollege(id);
		return list;
	}

	/**
	 * 添加用户
	 */
	@RequestMapping("/add")
	public String add(TTeacher teacher, String roleIds) {
		teacherService.save(teacher, roleIds);
		return "redirect:/page/base/teacher.action";
	}

	@RequestMapping("/page")
	public String page() {
		return "/base/teacher";
	}

	@RequestMapping("/userinfo")
	public String userinfoPage() {
		return "/admin/userinfo";
	}
}
