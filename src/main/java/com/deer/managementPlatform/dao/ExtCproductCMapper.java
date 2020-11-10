package com.deer.managementPlatform.dao;

import com.deer.managementPlatform.entity.ExtCproductC;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ExtCproductCMapper {
    /**
     * 查询全部
     * @return
     * @author wwt
     */
    List<ExtCproductC> findAll(String id);

    /**
     * 添加
     * @param
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
     * @param
     * @return
     */
    int update(ExtCproductC extCproductC);

    int deleteById(String extCproductId);
    /*int deleteByProduct(Map map);*/
    int deleteByProduct(@Param("id") String[] id);

}
