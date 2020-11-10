package com.deer.managementPlatform.service;

import com.deer.managementPlatform.entity.ExportC;

import java.util.List;
import java.util.Map;

public interface ExportCService {
    List<ExportC> findAll();
    String deleteall(Map map);
    int add(String[] contractIds);
    ExportC findById(String id);
}
