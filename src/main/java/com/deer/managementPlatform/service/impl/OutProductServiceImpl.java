package com.deer.managementPlatform.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.deer.managementPlatform.dao.OutProductMapper;
import com.deer.managementPlatform.entity.OutProductVO;
import com.deer.managementPlatform.service.OutProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;




@Service
public class OutProductServiceImpl implements OutProductService {
    @Resource
    private OutProductMapper outProductMapper;

    public List<OutProductVO> find(String inputDate) {
        Map paraMap = new HashMap();
        //按条件查询，船期
        paraMap.put("inputDate", inputDate);

        return outProductMapper.find(paraMap);
    }


}
