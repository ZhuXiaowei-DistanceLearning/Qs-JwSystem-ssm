package JW.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页面跳转
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/portal")
public class HomeAction {
	@RequestMapping("/gonggao")
	public String gonggaoPage() {
		return "/portal/gonggao";
	}

	@RequestMapping("/daiban")
	public String daibanPage() {
		return "/portal/daiban";
	}

	@RequestMapping("/yujing")
	public String yujingPage() {
		return "/portal/yujing";
	}

	@RequestMapping("/bug")
	public String bugPage() {
		return "/portal/bug";
	}

	@RequestMapping("/home")
	public String homePage() {
		return "/common/home";
	}
}
