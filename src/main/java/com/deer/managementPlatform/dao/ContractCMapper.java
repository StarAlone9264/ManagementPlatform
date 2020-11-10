package com.deer.managementPlatform.dao;

import com.deer.managementPlatform.entity.ContractC;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public interface ContractCMapper {
        /**
         * 查询全部
         * @return
         * @author wwt
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
        /**
         * 通过主键删除数据
         *
         * @param contractId 主键
         * @return 影响行数
         */
        int deleteById(String contractId);
        public int updateState(Map map);
        public int deleteall(Map map);
        //查询合同号，报运号
        ContractC view(String contractIds);

        /**
         * 产=删除 合同下的货物
         * @param id
         * @return
         */
       int  deleteByContractId(@Param("id") String[] id);

    }

