package com.deer.managementPlatform.service.impl;

import com.deer.managementPlatform.dao.ContractCMapper;
import com.deer.managementPlatform.entity.ContractC;
import com.deer.managementPlatform.service.ContractCService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class ContractCServiceImpl implements ContractCService {
    @Resource
    ContractCMapper contractCMapper;
    @Override
    public List<ContractC> findAll() {
        return contractCMapper.findAll();
    }

    @Override
    public int add(ContractC ContractC) {
        return contractCMapper.add(ContractC);
    }

    @Override
    public ContractC findById(String id) {
        return contractCMapper.findById(id);
    }

    @Override
    public int update(ContractC ContractC) {
        return contractCMapper.update(ContractC);
    }

    @Override
    public List<ContractC> startUsing() {
        return null;
    }

    @Override
    public List<ContractC> stopUsing() {
        return null;
    }


    @Override
    public int toStartUsing(String contractId) {
        return contractCMapper.toStartUsing(contractId);
    }

    @Override
    public int toStopUsing(String contractId) {
        return contractCMapper.toStopUsing(contractId);
    }
    @Override
    public int deleteById(String contractId) {return contractCMapper.deleteById(contractId);}
    @Override
    public String updateState(Map map){
        if (contractCMapper.updateState(map) > 0){
            return "success";
        }
        return "error";
    }
    @Override
    public String deleteall(Map map){
        if (contractCMapper.deleteall(map) > 0){
            return "success";
        }
        return "error";
    }

    @Override
    public ContractC view(String contractIds) {
        return contractCMapper.view(contractIds);
    }

    @Override
    public int deleteByContractId(String[] contractId) {
        System.err.println("输出："+contractId);
        return contractCMapper.deleteByContractId(contractId);
    }
}
