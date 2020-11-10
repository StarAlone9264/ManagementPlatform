package com.deer.managementPlatform.controller;

import com.deer.managementPlatform.entity.FactoryC;
import com.deer.managementPlatform.service.FactoryCService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangt
 */
@Controller
public class IndexController {
    @GetMapping({"/","index","index.html"})
    public String toIndex(){
        return "index";
    }


}
