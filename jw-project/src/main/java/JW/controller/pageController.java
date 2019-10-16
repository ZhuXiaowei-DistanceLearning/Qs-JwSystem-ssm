package JW.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zxw
 * @date 2019/10/16 14:12
 */
@Controller
@RequestMapping("page")
public class pageController {
    @RequestMapping("{category}/{page}")
    public String page(@PathVariable("category") String category, @PathVariable("page") String page) {
        return "/"+category + "/" + page;
    }
}
