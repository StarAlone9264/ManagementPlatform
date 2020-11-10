package com.deer.managementPlatform.service;

import com.deer.managementPlatform.entity.ExtEproductC;

import java.util.List;

/**
 * (ExtEproductC)表服务接口
 *
 * @author makejava
 * @since 2020-10-10 14:41:41
 */
public interface ExtEproductCService {

    /**
     * 通过ID查询单条数据
     *
     * @param extEproductId 主键
     * @return 实例对象
     */
    ExtEproductC queryById(String extEproductId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ExtEproductC> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param extEproductC 实例对象
     * @return 实例对象
     */
    ExtEproductC insert(ExtEproductC extEproductC);

    /**
     * 修改数据
     *
     * @param extEproductC 实例对象
     * @return 实例对象
     */
    int update(ExtEproductC extEproductC);

    /**
     * 通过主键删除数据
     *
     * @param extEproductId 主键
     * @return 是否成功
     */
    boolean deleteById(String extEproductId);

}