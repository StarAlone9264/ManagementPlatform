package com.deer.managementPlatform.service;

import com.deer.managementPlatform.entity.OutProductVO;

import java.util.List;

public interface OutProductService {
    //带条件查询，条件可以为null，既没有条件；返回list对象集合
    public List<OutProductVO> find(String inputDate);
}
