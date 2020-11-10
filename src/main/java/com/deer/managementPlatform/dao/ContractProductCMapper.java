package com.deer.managementPlatform.dao;

import com.deer.managementPlatform.entity.ContractProductC;
import com.deer.managementPlatform.entity.ContractProductC;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * (ContractProductC)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-23 15:42:33
 */
public interface ContractProductCMapper {
    /**
     * 查询全部
     * @return
     * @author wwt
     */
    /*List<ContractProductC> findAll(Map map);*/
    List<ContractProductC> findAll(String  id);
    List<ContractProductC> conFind();

    /**
     * 添加
     * @param
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
     * @param
     * @return
     */
    int update(ContractProductC contractProductC);

    int deleteById(String contractProductId);
    /*//删除合同下的货物
    public void deleteByContractId(Serializable[] ids);*/

    int deleteByContractId(@Param("id") String[] id);
}