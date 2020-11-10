package com.deer.managementPlatform.controller;

import com.deer.managementPlatform.entity.ExtEproductC;
import com.deer.managementPlatform.service.ExtEproductCService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (ExtEproductC)表控制层
 *
 * @author makejava
 * @since 2020-10-10 14:41:42
 */
@RestController
@RequestMapping("extEproductC")
public class ExtEproductCController {
    /**
     * 服务对象
     */
    @Resource
    private ExtEproductCService extEproductCService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ExtEproductC selectOne(String id) {
        return this.extEproductCService.queryById(id);
    }

}