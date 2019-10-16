package JW.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import JW.mapper.AuthFunctionMapperCustom;
import JW.mapper.AuthFunctionMapper;
import JW.mapper.RoleFunctionMapper;
import JW.mapper.TStudentMapper;
import JW.mapper.TTeacherMapper;
import JW.mapper.TUserMapper;
import JW.pojo.AuthFunction;
import JW.pojo.TStudent;
import JW.pojo.TStudentExample;
import JW.pojo.TTeacher;
import JW.pojo.TTeacherExample;
import JW.pojo.TUser;
import JW.pojo.TUserExample;
import JW.pojo.TUserExample.Criteria;
import JW.service.FunctionService;
import JW.service.StudentService;
import JW.service.TeacherService;
import JW.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.List;

/**
 * Created by Administrator on 2017/6/19.
 */
public class EMSshiro extends AuthorizingRealm {
	@Resource
	private UserService userSerivce;
	@Resource
	private TeacherService teacherService;
	@Resource
	private StudentService studentService;
	@Resource
	private FunctionService functionService;

	/**
	 * 授权方法
	 *
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Object object = principalCollection.getPrimaryPrincipal();
		List<AuthFunction> list = null;
		if (object instanceof TUser) {
			TUser user = (TUser) object;
			list = functionService.findAll();
		} else if (object instanceof TTeacher) {
			TTeacher teacher = (TTeacher) object;
			if (teacher.getQx().equals("院长")) {
				info.addStringPermission("yz");
			}
			list = functionService.findListByTeacherid(teacher.getTid());
		} else if (object instanceof TStudent) {
			TStudent student = (TStudent) object;
			list = functionService.findListByStudentid(student.getSid());
		}
		for (AuthFunction function : list) {
			info.addStringPermission(function.getCode());
		}
		return info;
	}

	/**
	 * 认证方法
	 *
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		Session session = SecurityUtils.getSubject().getSession();
		String RadioButtonList1 = (String) session.getAttribute("RadioButtonList1");
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		if (RadioButtonList1.equals("学生")) {
			TStudent student = studentService.findByUsername(username);
			String password = student.getPassword();
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(student, password,
					this.getClass().getSimpleName());
			return info;
		} else if (RadioButtonList1.equals("教师")) {
			TTeacher teacher = teacherService.findByUsername(username);
			if (teacher != null) {
				String password = teacher.getPassword();
				SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(teacher, password,
						this.getClass().getSimpleName());
				return info;
			}
		} else if (RadioButtonList1.equals("管理员")) {
			TUser user = userSerivce.findByUsername(username);
			if (user != null) {
				String password = user.getPassword();
				SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password,
						this.getClass().getSimpleName());
				return info;
			}
		}
		return null;
	}
}
