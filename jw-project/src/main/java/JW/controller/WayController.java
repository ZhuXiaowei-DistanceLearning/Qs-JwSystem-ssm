package JW.controller;

import JW.pojo.TExamway;
import JW.service.impl.WayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zxw
 * @date 2019/10/18 8:46
 */
@Controller
@RequestMapping("/way")
public class WayController {
    @Autowired
    WayService wayService;

    @RequestMapping("/listajax")
    @ResponseBody
    public List<TExamway> listajax() {
        List<TExamway> listajax = wayService.listajax();
        return listajax;
    }
}
