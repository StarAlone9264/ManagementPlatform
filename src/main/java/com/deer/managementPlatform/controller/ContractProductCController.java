package com.deer.managementPlatform.controller;

import com.deer.managementPlatform.entity.ContractC;
import com.deer.managementPlatform.entity.ContractProductC;
import com.deer.managementPlatform.entity.FactoryC;
import com.deer.managementPlatform.service.ContractCService;
import com.deer.managementPlatform.service.ContractProductCService;
import com.deer.managementPlatform.service.ExtCproductCService;
import com.deer.managementPlatform.service.FactoryCService;
import com.deer.managementPlatform.util.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (ContractProductC)表控制层
 *
 * @author makejava
 * @since 2020-09-23 15:42:33
 */
@Controller
@RequestMapping("/contractProductC")
public class ContractProductCController {
    /**
     * 服务对象
     */
    @Resource
    private ContractProductCService contractProductCService;
    @Resource
    private FactoryCService factoryCService;
    @Resource
    private ContractCService contractCService;
    @Resource
    private ExtCproductCService extCproductCService;
    @RequestMapping("/findAll/{contractId}")
    public String findAll(Model model, @PathVariable("contractId") String contractId){
        List<FactoryC> startUsing = factoryCService.startUsing();
        model.addAttribute("startUsing",startUsing);
        List<ContractC> contractCList = contractCService.findAll();
        model.addAttribute("contractCList",contractCList);
        List<ContractProductC> contractProductC = contractProductCService.findAll(contractId);
        model.addAttribute("contractProductC",contractProductC);
        return "contractProductC/findAllandadd";
    }

    @RequestMapping("/add")
    public  String add(ContractProductC contractProductC,Model model){
        contractProductC.setContractProductId(UUIDUtils.getUUID().toString());
        contractProductCService.add(contractProductC);
        return "redirect:/contractProductC/findAll/"+contractProductC.getContractId();

    }

    @RequestMapping("/findById/{contractProductId}")
    public  String findById(ContractProductC contractProductC, HttpServletRequest request, @PathVariable String contractProductId){
        List<FactoryC> startUsing = factoryCService.startUsing();
        request.setAttribute("startUsing", startUsing);
        ContractProductC contractProductCById = contractProductCService.findById(contractProductId);
        System.err.println(contractProductCById);
        request.setAttribute("contractProductCById", contractProductCById);
        return "contractProductC/update";
    }

    @RequestMapping("/update")
    public String update(ContractProductC contractProductC){
        int i = contractProductCService.update(contractProductC);
        return "redirect:/contractProductC/findAll/"+contractProductC.getContractId();
    }
   /* @RequestMapping("/delete/{contractProductId}")
    public String delete(@PathVariable("contractProductId")  String contractProductId, HttpServletRequest request, HttpSession session){
        ContractProductC ContractProductC = contractProductCService.findById(contractProductId);
        session.setAttribute("contractId",ContractProductC.getContractId());
        int contractId = Integer.parseInt(session.getAttribute("contractId").toString());
        extCproductCService.deleteByProduct(contractProductId);
        int i = contractProductCService.deleteById(contractProductId);
        return "redirect:/contractProductC/findAll/"+contractId;
    }*/
   /* @RequestMapping("/delete/{contractProductId}")
    public String deleteByProduct(String ids, HttpServletRequest request, HttpSession session){
        *//*删除产品下的所有附件*//*
            String[] split = ids.split(",");
            List<String> list = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                list.add(split[i]);
            }
            System.out.println(list);
            HashMap map = new HashMap();
            map.put("ids",list);
            return extCproductCService.deleteByProduct(map);
        }
        ContractProductC ContractProductC = contractProductCService.findById(contractProductId);
        session.setAttribute("contractId",ContractProductC.getContractId());
        int contractId = Integer.parseInt(session.getAttribute("contractId").toString());
        int i = contractProductCService.deleteById(contractProductId);
        return "redirect:/contractProductC/findAll/"+contractId;
    }*/
}