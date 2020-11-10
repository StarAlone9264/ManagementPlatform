package com.deer.managementPlatform.service.impl;

import com.deer.managementPlatform.dao.ExtCproductCMapper;
import com.deer.managementPlatform.entity.ExtCproductC;
import com.deer.managementPlatform.service.ExtCproductCService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("ExtCproductCService")
public class ExtCproductCServiceImpl implements ExtCproductCService {
    @Resource
    private ExtCproductCMapper extCproductCMapper;

    @Override
    public List<ExtCproductC> findAll(String id) {
        return extCproductCMapper.findAll(id);
    }

    @Override
    public int add(ExtCproductC extCproductC) {
        return extCproductCMapper.add(extCproductC);
    }


    @Override
    public ExtCproductC findById(String id) {
        return extCproductCMapper.findById(id);
    }

    @Override
    public int update(ExtCproductC extCproductC) {
        return extCproductCMapper.update(extCproductC);
    }


    /**
     * 通过主键删除数据
     *
     * @param extCproductId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(String extCproductId) {
        return extCproductCMapper.deleteById(extCproductId);
    }


    @Override
    public int deleteByProduct(String[]  contractProductId) { return extCproductCMapper.deleteByProduct(contractProductId);}
    /*@Override
    public String deleteByProduct(Map map){
        if (extCproductCMapper.deleteByProduct(map) > 0){
            return "success";
        }
        return "error";
    }*/

}
