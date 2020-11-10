package com.deer.managementPlatform.service;

import com.deer.managementPlatform.entity.ContractC;

import java.util.List;
import java.util.Map;

public interface ContractCService {
    /**
     * 查询全部
     * @return
     * @author wangt
     */
    List<ContractC> findAll();
    /**
     * 添加
     * @param contractC
     * @return
     */
    int add(ContractC contractC);

    /**
     * 根据ID查询单个数据
     * @param id
     * @return
     */
    ContractC findById(String id);

    /**
     * 修改
     * @param contractC
     * @return
     */
    int update(ContractC contractC);

    /**
     * 查询已启用
     * @return
     */
    List<ContractC> startUsing();

    /**
     * 查询已关闭
     * @return
     */
    List<ContractC> stopUsing();
    /**
     * 修改为已停用
     * @param contractId
     * @return
     */
    int toStartUsing(String contractId);

    /**
     * 修改为已启用
     * @param contractId
     * @return
     */
    int toStopUsing(String contractId);

    int deleteById(String contractId);

    String updateState(Map map);
    String deleteall(Map map);
    //查询合同号，报运号
    ContractC view(String contractId);
    int deleteByContractId(String[] contractId);
}
