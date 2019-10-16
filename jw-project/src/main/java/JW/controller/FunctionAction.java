package JW.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import JW.pojo.AuthFunction;
import JW.service.FunctionService;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import pojo.EasyUIDataGridResult;
import utils.JsonUtils;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/function")
public class FunctionAction {
    @Autowired
    private FunctionService functionSerivce;

    @RequestMapping("/pageQuery")
    @ResponseBody
    public EasyUIDataGridResult pageQuery(Integer page, Integer rows) throws IOException {
        EasyUIDataGridResult result = functionSerivce.pageQuery(page, rows);
        return result;
    }

    @RequestMapping("/listajax")
    @ResponseBody
    public List<AuthFunction> listajax() throws IOException {
        List<AuthFunction> list = functionSerivce.findAll();
        return list;
    }

    @RequestMapping("/add")
    public String add(AuthFunction function) {
        functionSerivce.save(function);
        return "/admin/function";
    }

    /**
     * @return
     * @throws IOException
     */
    @RequestMapping("findMenu")
    @ResponseBody
    public List<AuthFunction> findMenu(HttpServletResponse response) throws IOException {
        List<AuthFunction> list = functionSerivce.findMenu();
        return list;
    }

    @RequestMapping("/page")
    public String page() {
        return "/admin/function";
    }

    @RequestMapping("/function_add")
    public String function_addPage() {
        return "/admin/function_add";
    }
}
