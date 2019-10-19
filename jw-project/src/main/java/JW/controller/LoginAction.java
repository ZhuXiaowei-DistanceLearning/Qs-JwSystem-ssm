package JW.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import JW.listener.SessionListener;
import JW.pojo.TStudent;
import JW.pojo.TTeacher;
import JW.pojo.TUser;
import utils.CookieUtils;
import utils.E3Result;

@Controller
public class LoginAction {

	/**
	 * 登陆方法
	 */
	@RequestMapping("/home.action")
	@ResponseBody
	public E3Result login(String username, String password, String checkcode, String RadioButtonList1,
			HttpSession session, HttpServletResponse response, HttpServletRequest request) {
		// 获取验证码
		String key = (String) session.getAttribute("key");
		if (StringUtils.isNotBlank(checkcode) && checkcode.equals(key)) {
			Subject subject = SecurityUtils.getSubject();
			if (subject.getSession().getAttribute("user") != null) {
				subject.logout();
			}
			Session subjectSession = subject.getSession();
			subjectSession.setAttribute("RadioButtonList1", RadioButtonList1);
			AuthenticationToken token = new UsernamePasswordToken(username, password);
			try {
				subject.login(token);
			} catch (UnknownAccountException e) {
				e.printStackTrace();
				return E3Result.build(101, "用户名不存在");
			} catch (Exception e) {
				e.printStackTrace();
				return E3Result.build(114, "用户名或密码错误!");
			}
			Object user = subject.getPrincipal();
			if (user != null) {
				subjectSession.setAttribute("user", user);
				subjectSession.setAttribute("onlineNum", subjectSession.getId());
					return E3Result.ok(200);
			} else {
				return E3Result.build(114, "用户名或密码错误!");
			}
		} else {
			return E3Result.build(102, "验证码错误!");
		}
	}

	/**
	 * 获取keysession
	 *	获取subject对象
	 *	获取session
	 *AuthenticationToken，UsernamePasswordToken
	 *login
	 *set user
	 *set onlinenum
	 **/
	@RequestMapping("index")
	public String pageIndex() {
		return "/common/index";
	}
	
	/**
	 * 在线人数实时统计
	 * @return 
	 */
	@RequestMapping("/onlinePeople")
	@ResponseBody
	public Integer OnlinePeople(HttpServletRequest request,HttpServletResponse response){
		ServletContext context = request.getSession().getServletContext();
		Integer onlinePeople = (Integer) context.getAttribute("onlinePeople");
		return onlinePeople;
	}

	/**
	 * 用户退出时，销毁Session
	 * 
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/login.jsp";
	}
}
