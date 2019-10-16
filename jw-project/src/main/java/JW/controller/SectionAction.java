package JW.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import JW.pojo.TSection;
import JW.service.SectionService;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/section")
public class SectionAction {
	@Autowired
	private SectionService sectionService;

	@RequestMapping("/listajax")
	@ResponseBody
	public List<TSection> listajax() throws IOException {
		List<TSection> list = sectionService.findAll();
		return list;
	}
}
