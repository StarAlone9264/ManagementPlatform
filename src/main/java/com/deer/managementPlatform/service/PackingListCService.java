package com.deer.managementPlatform.service;

import com.deer.managementPlatform.entity.PackingListC;

import java.util.List;

public interface PackingListCService {
    public List<PackingListC> find();
    public String getDivDataCreate(String[] exportIds);
    int insert(PackingListC packingListC);
    PackingListC selcteById(String id);
    void update(PackingListC packingListC);
}
