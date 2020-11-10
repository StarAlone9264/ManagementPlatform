package com.deer.managementPlatform.controller;

import com.deer.managementPlatform.entity.ContractC;
import com.deer.managementPlatform.entity.ExportC;
import com.deer.managementPlatform.entity.FactoryC;
import com.deer.managementPlatform.service.ExportCService;
import com.deer.managementPlatform.service.FactoryCService;
import oracle.sql.ARRAY;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/exportC")
public class ExportCController {
    @Resource
    ExportCService exportCService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<ExportC> exportCList = exportCService.findAll();
        model.addAttribute("exportCList", exportCList);
        return "exportC/findAll";
    }
    //报运新增，直接进行后台保存
    @RequestMapping("/add")
    public String insert(String ids) { // 合同的id集合
        String[] contractIds = ids.split(",");
        exportCService.add(contractIds);
        return "redirect:/exportC/findAll";
    }
    @RequestMapping("/deleteall")
    @ResponseBody
    public String deleteall(String ids){
        String[] split = ids.split(",");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(split[i]);
        }
        System.out.println(list);
        HashMap map = new HashMap();
        map.put("ids",list);
        return exportCService.deleteall(map);
    }
}
