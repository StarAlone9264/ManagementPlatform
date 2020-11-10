package com.deer.managementPlatform.service;

import com.deer.managementPlatform.entity.FactoryC;

import java.util.List;
import java.util.Map;

/**
 * @author wwt
 */
public interface FactoryCService {
    /**
     * 查询全部
     * @return
     * @author wwt
     */
    List<FactoryC> findAll();
    /**
     * 添加
     * @param factoryC
     * @return
     */
    int add(FactoryC factoryC);

    /**
     * 根据ID查询单个数据
     * @param id
     * @return
     */
    FactoryC findById(String id);

    /**
     * 修改
     * @param factoryC
     * @return
     */
    int update(FactoryC factoryC);

    /**
     * 查询已启用
     * @return
     */
    List<FactoryC> startUsing();

    /**
     * 查询已关闭
     * @return
     */
    List<FactoryC> stopUsing();
    /**
     * 修改为已停用
     * @param factoryId
     * @return
     */
    int toStartUsing(String factoryId);

    /**
     * 修改为已启用
     * @param factoryId
     * @return
     */
    int toStopUsing(String factoryId);

    int deleteById(String factoryId);

    String updateState(Map map);
    String deleteall(Map map);
}
