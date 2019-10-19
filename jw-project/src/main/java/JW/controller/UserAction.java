package JW.controller;

import JW.pojo.TUser;
import JW.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.registry.infomodel.User;
import java.io.IOException;

/**
 *
 */
@Controller
@RequestMapping("/user")
//@Scope("prototype")
public class UserAction {

    @Autowired
    private UserService userService;

    @RequestMapping("/editPassword")
    @ResponseBody
    public String editPassword(String password) throws IOException {
        String flag = "0";
        try {
            TUser principal = (TUser) SecurityUtils.getSubject().getPrincipal();
            TUser user = userService.editPassword(password, principal.getId());
            if (user != null) {
                flag = "1";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public String pageQuery() throws IOException {
        return null;
    }

    private String[] roleIds;

    /**
     * 添加用户
     */
    public String add() {
        return null;
    }


    public String[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String[] roleIds) {
        this.roleIds = roleIds;
    }
}
