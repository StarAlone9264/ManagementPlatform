package com.deer.managementPlatform.controller;

import com.deer.managementPlatform.entity.ContractC;
import com.deer.managementPlatform.service.ContractCService;
import com.deer.managementPlatform.service.ContractProductCService;
import com.deer.managementPlatform.service.ExportCService;
import com.deer.managementPlatform.service.ExtCproductCService;
import com.deer.managementPlatform.util.ContractPrint;
import com.deer.managementPlatform.util.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/contractC")
public class ContractCController {
    @Resource
    ContractCService contractCService;
    @Resource
    ExportCService exportCService;
    @Resource
    ContractProductCService contractProductCService;
    @Resource
    ExtCproductCService extCproductCService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<ContractC> contractCList = contractCService.findAll();
        model.addAttribute("contractCList", contractCList);
        return "contractC/findAll";
    }

    @RequestMapping("/toAdd")
    public  String toAdd(){
        return "contractC/add";
    }

    @RequestMapping("/add")
    public  String add(ContractC contractC){
        contractC.setContractId(UUIDUtils.getUUID().toString())
        .setState(1);
        contractCService.add(contractC);
        return "redirect:/contractC/findAll";
    }

    @RequestMapping("/findById/{contractId}")
    public  String findById(ContractC ContractC, HttpServletRequest request, @PathVariable String contractId){
        ContractC contractCById = contractCService.findById(contractId);
        System.err.println(contractCById);
        request.setAttribute("contractCById", contractCById);
        return "contractC/update";
    }

    @RequestMapping("/update")
    public String update(ContractC contractC){
        int i = contractCService.update(contractC);
        return "redirect:/contractC/findAll";
    }
    @RequestMapping("/startUsing")
    public  String startUsing(HttpServletRequest request){
        List<ContractC> contractCList = contractCService.startUsing();
        request.setAttribute("contractCList", contractCList);
        return "contractC/startUsing";
    }

    @RequestMapping("/stopUsing")
    public String stopUsing(HttpServletRequest request){
        List<ContractC> contractCList = contractCService.stopUsing();
        request.setAttribute("contractCList", contractCList);
        return "contractC/stopUsing";
    }

    @RequestMapping("/toStartUsing/{contractId}")
    public  String toStartUsing(@PathVariable("contractId")  String contractId){
        contractCService.toStartUsing(contractId);
        System.out.println("0");
        return "redirect:/contractC/findAll";
    }
    @RequestMapping("/toStopUsing/{contractId}")
    public  String toStopUsing(@PathVariable String contractId){
        contractCService.toStopUsing(contractId);
        return "redirect:/contractC/findAll";
    }
    /**
     * 根据ID删除
     * @param
     * @return
     */
    @RequestMapping("/delete/{contractId}")
    public String delete(@PathVariable("contractId") String contractId,Model model) {
        /*String substring = str.substring(1,str.length()-1);
        String[] split = substring.split(",");
        for (int i = 0; i < split.length; i++) {
            ContractCService.deleteById(split[i]);
        }*/
        contractCService.deleteById(contractId);
        return "redirect:/contractC/findAll";
    }
//    待报运
    @RequestMapping("/tostate")
    @ResponseBody
    public String tostate(String ids){
        System.out.println(ids);
        String[] split = ids.split(",");

        List<String> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(split[i]);
        }
        System.out.println(list);
        HashMap map = new HashMap();
        map.put("ids",list);
        map.put("state","3");
      /*  exportCService.add(split);
        for(int i =0;i<split.length;i++){System.out.println(split[i]); }*/
        return contractCService.updateState(map);
    }
    /*归档*/
    @RequestMapping("/archivestate")
    @ResponseBody
    public String archivestate(String ids){
        System.out.println("0");
        String[] split = ids.split(",");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(split[i]);
        }
        System.out.println(list);
        HashMap map = new HashMap();
        map.put("ids",list);
        map.put("state","0");
        return contractCService.updateState(map);
    }
    /*报运*/
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
        return contractCService.updateState(map);
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
        return contractCService.deleteall(map);
    }

    @RequestMapping("/print")
    @ResponseBody
    public void print(String ids, HttpServletRequest request, HttpSession session, HttpServletResponse response) throws Exception {
        System.err.println(ids);
        ContractC view = contractCService.view(ids);
        System.err.println(view);
        ContractPrint cop = new ContractPrint();
        cop.print(view,request.getSession().getServletContext().getRealPath("/"),response);
    }

    @RequestMapping("/deleteByContractId/{contractId}")
    public String deleteByContractId(@PathVariable("contractId") String[] contractId){
        extCproductCService.deleteByProduct(contractId);
        contractProductCService.deleteByContractId(contractId);
        contractCService.deleteByContractId(contractId);
        return "redirect:/contractC/findAll";
    }
}
