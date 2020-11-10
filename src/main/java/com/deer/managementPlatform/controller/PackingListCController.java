package com.deer.managementPlatform.controller;

import com.deer.managementPlatform.entity.PackingListC;
import com.deer.managementPlatform.service.PackingListCService;
import com.deer.managementPlatform.util.UUIDUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/packingListC")
public class PackingListCController extends BaseController {
    @Resource
    private PackingListCService packingListCService;

    @RequestMapping("/findAll")
    public String list(Model model) {
        List<PackingListC> dataList = packingListCService.find();
        model.addAttribute("dataList", dataList);

        return "/packingListC/findAll";
    }

    @RequestMapping("/tocreate")
    @ResponseBody
    public String tocreate(HttpSession session, String[] ids, Model model) {            //出口报运的id集合
        //携带出口报运的id集合	//显示装箱和报运的关系
        session.removeAttribute("ids");
        session.setAttribute("ids", ids);
        return "success";
    }

    @PostMapping("/getDivData")
    @ResponseBody
    public String getDivData(HttpSession session) {
        String[] ids = (String[]) session.getAttribute("ids");
        if (ids.length < 0){
            return "error";
        }
        return packingListCService.getDivDataCreate(ids);
    }

    @RequestMapping("/insert")
    public String insert(PackingListC packingListC) {
        packingListC.setPackingListId(UUIDUtils.getUUID().toString());

        packingListCService.insert(packingListC);

        return "redirect:/packingListC/findAll";
    }
    //去修改页面：
    @RequestMapping("/toupdate/{packingListId}")
    public String toupdate(@PathVariable String packingListId, Model model){
        PackingListC packingListC = packingListCService.selcteById(packingListId);
        model.addAttribute("packingListC",packingListC);
        return "/packinglistC/update";
    }
   /* @PostMapping("/getUDivData")
    @ResponseBody
    public String getUDivData(HttpSession session) {
        String[] ids = (String[]) session.getAttribute("ids");
        if (ids.length < 0){
            return "error";
        }
        return packingListCService.getDivDataCreate(ids);
    }*/
    //真正修改
    @RequestMapping("/update")
    public String update(PackingListC packingListC){
        packingListCService.update(packingListC);

        return "redirect:/packinglistC/findAll";
    }


}