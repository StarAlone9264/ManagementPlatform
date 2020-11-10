package com.deer.managementPlatform.dao;

import com.deer.managementPlatform.entity.FactoryC;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangt
 */
public interface FactoryCMapper {
    /**
     * 查询全部
     * @return
     * @author wangt
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
    /*FactoryC findByStar();*/

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
    /**
     * 通过主键删除数据
     *
     * @param factoryId 主键
     * @return 影响行数
     */
    int deleteById(String factoryId);
    public int updateState(Map map);
    public int deleteall(Map map);
}
