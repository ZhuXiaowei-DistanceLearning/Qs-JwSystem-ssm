package JW.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import JW.pojo.TCourse;
import JW.pojo.TTeacher;
import JW.service.CourseService;
import pojo.EasyUIDataGridResult;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/course")
public class CourseAction {
	@Autowired
	private CourseService courseService;

	@RequestMapping("/pageQuery")
	@ResponseBody
	public EasyUIDataGridResult pageQuery(Integer page, Integer rows) throws IOException {
		EasyUIDataGridResult result = courseService.pageQuery(page, rows);
		return result;
	}

	/**
	 * subject获取对象
	 * @return courseAndStudent
	 * @param natureId
	 * @return
	 */
	@RequestMapping("/add")
	public String add(TCourse model, String sectionId, String weekId, String teacherTid, String natureId) {
		model.setSectionId(sectionId);
		model.setWeekId(weekId);
		model.setTeacherId(teacherTid);
		model.setNatureId(natureId);
		courseService.add(model);
		return "/base/courseInfo";
	}

	@RequestMapping("/findCourseByteacherId")
	@ResponseBody
	public EasyUIDataGridResult findCourseByteacherId(HttpSession session, Integer page, Integer rows)
			throws IOException {
		TTeacher teacher = (TTeacher) SecurityUtils.getSubject().getPrincipal();
		EasyUIDataGridResult result = courseService.findCourseByteacherId(page, rows, teacher.getTid());
		session.setAttribute("courseAndStudent", result);
		return result;
	}

	@RequestMapping("/page")
	public String page() {
		return "/base/course";
	}

	@RequestMapping("/techaerPage")
	public String findCourseByteacherId() {
		return "/teacher/course";
	}

	@RequestMapping("/studentPage")
	public String findCourseByStudent() {
		return "/student/course";
	}

	/**
	 * findById
	 * session
	 * RETURN addStudentScore
	 * @return
	 */
	@RequestMapping("/pageInfo")
	public String pageInfo() {
		return "/base/courseInfo";
	}

	@RequestMapping("/addScorePage")
	public String addScorePage(String courseid, HttpSession session) {
		TCourse course = courseService.findById(courseid);
		session.setAttribute("addStudentScore", course);
		return "/teacher/score";
	}
}
