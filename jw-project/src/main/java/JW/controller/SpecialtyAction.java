package JW.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import JW.pojo.TSpecialty;
import JW.service.SpecialtyService;
import pojo.EasyUIDataGridResult;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/specialty")
public class SpecialtyAction {

    @Autowired
    private SpecialtyService specialtyService;

    @RequestMapping("redoSpecialty")
    @ResponseBody
    public String redoSpecialty(String id) {
        specialtyService.redoSpecialty(id);
        return "true";
    }

    @RequestMapping("/pageQuery")
    @ResponseBody
    public EasyUIDataGridResult pageQuery(Integer page, Integer rows) throws IOException {
        EasyUIDataGridResult result = specialtyService.pageQuery(page, rows);
        return result;
    }

    @RequestMapping("/addSpecialty")
    public String addSpecialty(TSpecialty specialty) {
        specialtyService.add(specialty);
        return "redirect:/page/base/specialty.action";
    }

    @RequestMapping("/updateSpecialty")
    public String updateSpecialty(TSpecialty specialty) {
        specialtyService.update(specialty);
        return "redirect:/page/base/specialty.action";
    }

    @RequestMapping("/delete")
    public String delete(String ids) {
        specialtyService.deleteBatch(ids);
        return "redirect:/page/base/specialty.action";
    }

    @RequestMapping("/listajax")
    @ResponseBody
    public List<TSpecialty> listajax(String id) throws IOException {
        List<TSpecialty> list = specialtyService.listajax(id);
        return list;
    }

    @RequestMapping("/page")
    public String page() {
        return "/base/specialty";
    }

}
