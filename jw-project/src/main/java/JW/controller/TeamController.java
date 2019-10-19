package JW.controller;

import JW.pojo.TTeam;
import JW.service.impl.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zxw
 * @date 2019/10/18 8:45
 */
@Controller
@RequestMapping("/team")
public class TeamController {
    @Autowired
    TeamService teamService;

    @RequestMapping("/listajax")
    @ResponseBody
    public List<TTeam> listajax(){
        List<TTeam> listajax = teamService.listajax();
        return listajax;
    }
}
