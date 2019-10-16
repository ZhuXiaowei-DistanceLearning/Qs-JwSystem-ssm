package JW.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import JW.pojo.AuthRole;
import JW.service.RoleSerivce;
import pojo.EasyUIDataGridResult;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleAction {
	@Autowired
	private RoleSerivce roleSerivce;

	@RequestMapping("/add")
	public String add(String ids, AuthRole role) {
		roleSerivce.save(role, ids);
		return "/admin/role";
	}

	@RequestMapping("/pageQuery")
	@ResponseBody
	public EasyUIDataGridResult pageQuery(Integer page, Integer rows) throws IOException {
		EasyUIDataGridResult result = roleSerivce.pageQuery(page, rows);
		return result;
	}

	@RequestMapping("/listajax")
	@ResponseBody
	public List<AuthRole> listajax() throws IOException {
		List<AuthRole> list = roleSerivce.findAll();
		return list;
	}

	@RequestMapping("/page")
	public String page() {
		return "/admin/role";
	}

	@RequestMapping("/pageAdd")
	public String pageAdd() {
		return "/admin/role_add";
	}
}
