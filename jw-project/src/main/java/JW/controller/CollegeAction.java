package JW.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import JW.pojo.AuthFunction;
import JW.pojo.TCollege;
import JW.service.CollegeService;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import pojo.EasyUIDataGridResult;
import utils.E3Result;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/college")
public class CollegeAction {
	@Autowired
	private CollegeService collegeService;

	/**
	 * 分页查询
	 *
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/pageQuery")
	@ResponseBody
	public EasyUIDataGridResult pageQuery(Integer page, Integer rows) throws IOException {
		EasyUIDataGridResult result = collegeService.pageQuery(page, rows);
		return result;
	}

	/**
	 * 增加学院
	 *
	 * @return
	 */
	@RequestMapping("addCollege")
	public String addCollege(TCollege model) {
		collegeService.save(model);
		return "redirect:/page/base/college.action";
	}

	/**
	 * ɾ��
	 *
	 * @return
	 */
	@RequestMapping("deleteCollege")
	@ResponseBody
	public E3Result delete(String ids) {
		E3Result result = collegeService.delete(ids);
		return result;
	}

	@RequestMapping("redoCollege")
	@ResponseBody
	public String redoCollege(String id) {
		collegeService.collectRedo(id);
		return "true";
	}

	/**
	 * findListNostatus找到
	 *
	 * @return
	 */
	@RequestMapping("editCollege")
	public String editCollege(TCollege model) {
		collegeService.edit(model);
		return "redirect:/page/base/college.action";
	}

	/**
	 * 查询列表
	 */
	@RequestMapping("listajax")
	@ResponseBody
	public List<TCollege> listajax(HttpServletResponse response) throws IOException {
		List<TCollege> list = collegeService.findListNostatus();
		return list;
	}

	@RequestMapping("/page")
	public String page() {
		return "/base/college";
	}
}
