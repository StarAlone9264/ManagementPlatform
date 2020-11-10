package com.deer.managementPlatform.service;

import com.deer.managementPlatform.entity.ExportProductC;

import java.util.List;

/**
 * (ExportProductC)表服务接口
 *
 * @author makejava
 * @since 2020-10-10 14:30:09
 */
public interface ExportProductCService {

    /**
     * 通过ID查询单条数据
     *
     * @param exportProductId 主键
     * @return 实例对象
     */
    ExportProductC queryById(String exportProductId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ExportProductC> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param exportProductC 实例对象
     * @return 实例对象
     */
    ExportProductC insert(ExportProductC exportProductC);

    /**
     * 修改数据
     *
     * @param exportProductC 实例对象
     * @return 实例对象
     */
    ExportProductC update(ExportProductC exportProductC);

    /**
     * 通过主键删除数据
     *
     * @param exportProductId 主键
     * @return 是否成功
     */
    boolean deleteById(String exportProductId);

}