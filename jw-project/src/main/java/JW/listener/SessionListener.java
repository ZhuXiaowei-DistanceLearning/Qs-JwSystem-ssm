package JW.listener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class SessionListener implements HttpSessionAttributeListener, HttpSessionListener {

	List<String> list = new ArrayList<>();
	Integer onlinePeople = 0;

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		try {
			Subject subject = SecurityUtils.getSubject();
			if (subject.isAuthenticated()) {
				Session session = subject.getSession();
				Serializable session_id = (Serializable) session.getAttribute("onlineNum");
				ServletContext context = se.getSession().getServletContext();
				Integer people = (Integer) context.getAttribute("onlinePeople");
				if (people == null) {
					people = onlinePeople;
				}
				if (session_id == null) {

				} else {
					if (list.contains(session_id.toString())) {
					} else {
						list.add(session_id.toString());
						if (onlinePeople == 0) {
							onlinePeople = 1;
							context.setAttribute("onlinePeople", onlinePeople);
						} else {
							onlinePeople += 1;
							context.setAttribute("onlinePeople", onlinePeople);
						}
						System.out.println("有人登陆了系统，当前在线人数为：" + onlinePeople);
					}
				}
			}
		} catch (Exception e) {
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {

	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session创建了");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		Subject subject = SecurityUtils.getSubject();
		List<String> list = new ArrayList<>();
		if (subject.isAuthenticated()) {
			Session session = subject.getSession();
			ServletContext context = se.getSession().getServletContext();
			onlinePeople = (Integer) context.getAttribute("onlinePeople");
			String session_id = (String) session.getAttribute("onlineNum");
			if (list.contains(session_id)) {
			} else {
				list.remove(session_id);
				onlinePeople -= 1;
				context.setAttribute("onlinePeople", onlinePeople);
			}
			System.out.println("有人退出了系统，当前在线人数为：" + onlinePeople);
		}
	}
}
