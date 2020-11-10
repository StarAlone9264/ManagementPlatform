package com.deer.managementPlatform.controller;

import com.deer.managementPlatform.entity.ExportProductC;
import com.deer.managementPlatform.service.ExportProductCService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (ExportProductC)表控制层
 *
 * @author makejava
 * @since 2020-10-10 14:30:09
 */
@RestController
@RequestMapping("exportProductC")
public class ExportProductCController {
    /**
     * 服务对象
     */
    @Resource
    private ExportProductCService exportProductCService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ExportProductC selectOne(String id) {
        return this.exportProductCService.queryById(id);
    }

}