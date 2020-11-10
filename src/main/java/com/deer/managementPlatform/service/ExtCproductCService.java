package com.deer.managementPlatform.service;

import com.deer.managementPlatform.entity.ExtCproductC;

import java.util.List;
import java.util.Map;

public interface ExtCproductCService {
    /**
     * 查询全部
     * @return
     * @author wwt
     */
    List<ExtCproductC> findAll(String id);
    /**
     * 添加
     * @param extCproductC
     * @return
     */
    int add(ExtCproductC extCproductC);

    /**
     * 根据ID查询单个数据
     * @param id
     * @return
     */
    ExtCproductC findById(String id);

    /**
     * 修改
     * @param extCproductC
     * @return
     */
    int update(ExtCproductC extCproductC);

    /**
     * 通过主键删除数据
     *
     * @param extCproductId 主键
     * @return 是否成功
     */
    int deleteById(String extCproductId);
    int deleteByProduct(String[] contractProductId);

    /*String deleteByProduct(Map map);*/

}
