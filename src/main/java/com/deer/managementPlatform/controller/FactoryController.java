package com.deer.managementPlatform.controller;

import com.deer.managementPlatform.entity.FactoryC;
import com.deer.managementPlatform.service.FactoryCService;
import com.deer.managementPlatform.util.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wangt
 */
@Controller
@RequestMapping("/factoryC")
public class FactoryController {
    @Resource
    FactoryCService factoryCService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<FactoryC> factoryCList = factoryCService.findAll();
        model.addAttribute("factoryCList", factoryCList);
        return "factoryC/findAll";
    }

    @RequestMapping("/toAdd")
    public  String toAdd(){
        return "factoryC/add";
    }

    @RequestMapping("/add")
    public  String add(FactoryC factoryC){
        factoryC.setFactoryId(UUIDUtils.getUUID().toString());
        factoryCService.add(factoryC);
        return "redirect:/factoryC/findAll";
    }

    @RequestMapping("/findById/{factoryId}")
    public  String findById(FactoryC factoryC, HttpServletRequest request, @PathVariable String factoryId){
        FactoryC factoryCById = factoryCService.findById(factoryId);
        System.err.println(factoryCById);
        request.setAttribute("factoryCById", factoryCById);
        return "factoryC/update";
    }

    @RequestMapping("/update")
    public String update(FactoryC factoryC){
        factoryCService.update(factoryC);
        return "redirect:/factoryC/findAll";
    }
    @RequestMapping("/startUsing")
    public  String startUsing(HttpServletRequest request){
        List<FactoryC> factoryCList = factoryCService.startUsing();
        request.setAttribute("factoryCList", factoryCList);
        return "factoryC/startUsing";
    }

    @RequestMapping("/stopUsing")
    public String stopUsing(HttpServletRequest request){
        List<FactoryC> factoryCList = factoryCService.stopUsing();
        request.setAttribute("factoryCList", factoryCList);
        return "factoryC/stopUsing";
    }

    @RequestMapping("/toStartUsing/{factoryId}")
    public  String toStartUsing(@PathVariable  String factoryId){
        factoryCService.toStartUsing(factoryId);
        System.out.println("0");
        return "redirect:/factoryC/findAll";
    }
    @RequestMapping("/toStopUsing/{factoryId}")
    public  String toStopUsing(@PathVariable String factoryId){
        factoryCService.toStopUsing(factoryId);
        return "redirect:/factoryC/findAll";
    }
    /**
     * 根据ID删除
     * @param
     * @return
     */
    @RequestMapping("/delete/{factoryId}")
    public String delete(@PathVariable("factoryId") String factoryId,Model model) {
        /*String substring = str.substring(1,str.length()-1);
        String[] split = substring.split(",");
        for (int i = 0; i < split.length; i++) {
            factoryCService.deleteById(split[i]);
        }*/
        factoryCService.deleteById(factoryId);
        return "redirect:/factoryC/findAll";
    }
    @RequestMapping("/tostate")
    @ResponseBody
    public String tostate(String ids){
        System.out.println("0");
        String[] split = ids.split(",");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(split[i]);
        }
        System.out.println(list);
        HashMap map = new HashMap();
        map.put("ids",list);
        map.put("state","1");
        return factoryCService.updateState(map);
    }
    @RequestMapping("/outstate")
    @ResponseBody
    public String outstate(String ids){
        System.out.println("0");
        String[] split = ids.split(",");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(split[i]);
        }
        System.out.println(list);
        HashMap map = new HashMap();
        map.put("ids",list);
        map.put("state","2");
        return factoryCService.updateState(map);
    }
    @RequestMapping("/deleteall")
    @ResponseBody
    public String deleteall(String ids){
        System.out.println("deleteall");
        String[] split = ids.split(",");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(split[i]);
        }
        System.out.println(list);
        HashMap map = new HashMap();
        map.put("ids",list);
        return factoryCService.deleteall(map);
    }
}
