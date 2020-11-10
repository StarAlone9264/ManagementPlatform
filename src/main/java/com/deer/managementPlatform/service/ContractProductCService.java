package com.deer.managementPlatform.service;

import com.deer.managementPlatform.entity.ContractProductC;
import com.deer.managementPlatform.entity.ContractProductC;
import java.util.List;
import java.util.Map;

/**
 * (ContractProductC)表服务接口
 *
 * @author makejava
 * @since 2020-09-23 15:42:33
 */
public interface ContractProductCService {
    /**
     * 查询全部
     * @return
     * @author wwt
     */
    List<ContractProductC> findAll(String id);
    /*List<ContractProductC> findAll(Map map);*/
    /**
     * 添加
     * @param contractProductC
     * @return
     */
    int add(ContractProductC contractProductC);

    /**
     * 根据ID查询单个数据
     * @param id
     * @return
     */
    ContractProductC findById(String id);

    /**
     * 修改
     * @param contractProductC
     * @return
     */
    int update(ContractProductC contractProductC);

    /**
     * 通过主键删除数据
     *
     * @param contractProductId 主键
     * @return 是否成功
     */
    int deleteById(String contractProductId);
    List<ContractProductC> conFind();

    int deleteByContractId(String[] id);
}