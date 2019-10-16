package JW.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import JW.pojo.TNature;
import JW.service.NatureService;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/nature")
public class NatureAction {
	@Autowired
	private NatureService natureService;

	@RequestMapping("/listajax")
	@ResponseBody
	public List<TNature> listajax() throws IOException {
		List<TNature> list = natureService.findAll();
		return list;
	}
}
