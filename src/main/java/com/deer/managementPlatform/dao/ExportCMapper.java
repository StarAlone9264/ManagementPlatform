package com.deer.managementPlatform.dao;

import com.deer.managementPlatform.entity.ExportC;

import java.util.List;
import java.util.Map;

public interface ExportCMapper {
    List<ExportC> findAll();
    int add(ExportC exportC);
    ExportC findById(String id);
    String deleteall(Map map);
}
