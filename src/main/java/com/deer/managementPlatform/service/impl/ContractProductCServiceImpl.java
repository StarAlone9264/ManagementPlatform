package com.deer.managementPlatform.service.impl;

import com.deer.managementPlatform.entity.ContractProductC;
import com.deer.managementPlatform.dao.ContractProductCMapper;
import com.deer.managementPlatform.service.ContractProductCService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ContractProductC)表服务实现类
 *
 * @author makejava
 * @since 2020-09-23 15:42:33
 */

@Service("contractProductCService")
public class ContractProductCServiceImpl implements ContractProductCService {
    @Resource
    private ContractProductCMapper contractProductCMapper;

    @Override
    /*public List<ContractProductC> findAll(Map map) {
        return contractProductCMapper.findAll(map);
    }*/
    public List<ContractProductC> findAll(String id) {
        return contractProductCMapper.findAll(id);
    }

    @Override
    public int add(ContractProductC ContractProductC) {
        return contractProductCMapper.add(ContractProductC);
    }

    @Override
    public ContractProductC findById(String id) {
        return contractProductCMapper.findById(id);
    }

    @Override
    public int update(ContractProductC ContractProductC) {
        return contractProductCMapper.update(ContractProductC);
    }

    /**
     * 通过主键删除数据
     *
     * @param contractProductId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(String contractProductId) {
        return contractProductCMapper.deleteById(contractProductId);
    }
    @Override
    public List<ContractProductC> conFind() {
        return contractProductCMapper.conFind();
    }

    @Override
    public int deleteByContractId(String[] id) {
        return contractProductCMapper.deleteByContractId(id);
    }
    /*//删除合同下的货物
    @Override
    public void deleteByContractId(Serializable[] ids) {
        super.getSqlSession().delete(super.getNs() + ".deleteByContractId", ids);
    }*/
}