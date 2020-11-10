package com.deer.managementPlatform.controller;

import com.deer.managementPlatform.entity.ExtCproductC;
import com.deer.managementPlatform.entity.ContractProductC;
import com.deer.managementPlatform.entity.FactoryC;
import com.deer.managementPlatform.service.ExtCproductCService;
import com.deer.managementPlatform.service.ContractProductCService;
import com.deer.managementPlatform.service.FactoryCService;
import com.deer.managementPlatform.util.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (ContractProductC)表控制层
 *
 * @author makejava
 * @since 2020-09-23 15:42:33
 */
@Controller
@RequestMapping("/extCproductC")
public class ExtCproductCController {
    @Resource
    private ContractProductCService contractProductCService;
    @Resource
    private FactoryCService factoryCService;
    @Resource
    private ExtCproductCService extCproductCService;

    @RequestMapping("/findAll/{id}")
    public String findAll(@PathVariable("id") String id, HttpServletRequest request) {
        List<ExtCproductC> extCproductCList = extCproductCService.findAll(id);
        request.setAttribute("ExtCproductCList", extCproductCList);

        List<FactoryC> startUsing = factoryCService.startUsing();
        request.setAttribute("startUsing", startUsing);

        List<FactoryC> findAll = factoryCService.findAll();
        request.setAttribute("findAll", findAll);

        List<ContractProductC> ContractProductC = contractProductCService.conFind();
        request.setAttribute("ContractProductC", ContractProductC);
        request.setAttribute("id",id);
        return "extCproductC/findAllandadd";
    }

    @RequestMapping("/add")
    public String add(ExtCproductC extCproductC, Model model) {
        System.err.println(extCproductC);
        extCproductC.setExtCproductId(UUIDUtils.getUUID().toString());
        extCproductCService.add(extCproductC);
        /*HashMap map = new HashMap();
        map.put("contractId",contractProductC.getContractId());*/
        return "redirect:/extCproductC/findAll/"+extCproductC.getContractProductId();
    }

    @RequestMapping("/findById/{extCproductId}")
    public String findById(ExtCproductC extCproductC, HttpServletRequest request, @PathVariable String extCproductId) {
        List<FactoryC> startUsing = factoryCService.startUsing();
        request.setAttribute("startUsing", startUsing);
        List<FactoryC> findAll = factoryCService.findAll();
        request.setAttribute("findAll", findAll);
        ExtCproductC extCproductCById = extCproductCService.findById(extCproductId);
        System.err.println(extCproductId);
        request.setAttribute("extCproductCById", extCproductCById);
        return "extCproductC/update";
    }

    @RequestMapping("/update")
    public String update(ExtCproductC extCproductC) {
        int i = extCproductCService.update(extCproductC);
        return "redirect:/extCproductC/findAll/"+extCproductC.getContractProductId();
    }

    @RequestMapping("/delete/{extCproductId}")
    public String delete(@PathVariable("extCproductId") String extCproductId,HttpSession session,HttpServletRequest request) {
        ExtCproductC extCproductC = extCproductCService.findById(extCproductId);
        System.err.println(extCproductC.getContractProductId());
        session.setAttribute("contractProductId",extCproductC.getContractProductId());
        int contractProductId =Integer.parseInt(session.getAttribute("contractProductId").toString());
        int i = extCproductCService.deleteById(extCproductId);
        return "redirect:/extCproductC/findAll/"+contractProductId;
    }
}
