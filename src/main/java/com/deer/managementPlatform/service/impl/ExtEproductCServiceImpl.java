package com.deer.managementPlatform.service.impl;

import com.deer.managementPlatform.dao.ExtEproductCMapper;
import com.deer.managementPlatform.entity.ExtEproductC;
import com.deer.managementPlatform.service.ExtEproductCService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ExtEproductC)表服务实现类
 *
 * @author makejava
 * @since 2020-10-10 14:41:41
 */
@Service("extEproductCService")
public class ExtEproductCServiceImpl implements ExtEproductCService {
    @Resource
    private ExtEproductCMapper extEproductCMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param extEproductId 主键
     * @return 实例对象
     */
    @Override
    public ExtEproductC queryById(String extEproductId) {
        return this.extEproductCMapper.queryById(extEproductId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<ExtEproductC> queryAllByLimit(int offset, int limit) {
        return this.extEproductCMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param extEproductC 实例对象
     * @return 实例对象
     */
    @Override
    public ExtEproductC insert(ExtEproductC extEproductC) {
        this.extEproductCMapper.insert(extEproductC);
        return extEproductC;
    }

    /**
     * 修改数据
     *
     * @param extEproductC 实例对象
     * @return 实例对象
     */
    @Override
    public int update(ExtEproductC extEproductC) {

        return extEproductCMapper.update(extEproductC);
    }

    /**
     * 通过主键删除数据
     *
     * @param extEproductId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String extEproductId) {
        return this.extEproductCMapper.deleteById(extEproductId) > 0;
    }
}