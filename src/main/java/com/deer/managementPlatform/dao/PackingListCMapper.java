package com.deer.managementPlatform.dao;

import com.deer.managementPlatform.entity.ExportC;
import com.deer.managementPlatform.entity.PackingListC;

import java.util.List;
import java.util.Map;

public interface PackingListCMapper extends BaseMapper<PackingListC> {
    public List<PackingListC> find();
    public String getDivDataCreate(String[] exportIds);
    ExportC findById(String id);
    int add(PackingListC packingListC);
    PackingListC selcteById(String id);
    void update(PackingListC packingListC);
}
