package JW.controller;

import JW.pojo.TCstatus;
import JW.service.impl.CStatusService;
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
@RequestMapping("/cstatus")
public class CStatusController {
    @Autowired
    private CStatusService statusService;

    @RequestMapping("/listajax")
    @ResponseBody
    public List<TCstatus> listajax() {
        List<TCstatus> listajax = statusService.listajax();
        return listajax;
    }
}
