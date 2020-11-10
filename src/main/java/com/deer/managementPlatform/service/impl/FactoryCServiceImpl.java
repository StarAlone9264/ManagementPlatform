package com.deer.managementPlatform.service.impl;

import com.deer.managementPlatform.dao.FactoryCMapper;
import com.deer.managementPlatform.entity.FactoryC;
import com.deer.managementPlatform.service.FactoryCService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wwt
 */
@Service
public  class FactoryCServiceImpl implements FactoryCService {
    @Resource
    FactoryCMapper factoryCMapper;
    @Override
    public List<FactoryC> findAll() {
        return factoryCMapper.findAll();
    }

    @Override
    public int add(FactoryC factoryC) {
        return factoryCMapper.add(factoryC);
    }

    @Override
    public FactoryC findById(String id) {
        return factoryCMapper.findById(id);
    }

    @Override
    public int update(FactoryC factoryC) {
        return factoryCMapper.update(factoryC);
    }

    @Override
    public List<FactoryC> startUsing() {
        return factoryCMapper.startUsing();
    }

    @Override
    public List<FactoryC> stopUsing() {
        return factoryCMapper.stopUsing();
    }

    @Override
    public int toStartUsing(String factoryId) {
        return factoryCMapper.toStartUsing(factoryId);
    }

    @Override
    public int toStopUsing(String factoryId) {
        return factoryCMapper.toStopUsing(factoryId);
    }
    @Override
    public int deleteById(String factoryId) {return factoryCMapper.deleteById(factoryId);}
    @Override
    public String updateState(Map map){
        if (factoryCMapper.updateState(map) > 0){
        return "success";
    }
        return "error";
    }
    @Override
    public String deleteall(Map map){
        if (factoryCMapper.deleteall(map) > 0){
        return "success";
    }
        return "error";
    }
}
