package com.deer.managementPlatform.service.impl;

import com.deer.managementPlatform.dao.ExportProductCMapper;
import com.deer.managementPlatform.entity.ExportProductC;
import com.deer.managementPlatform.service.ExportProductCService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ExportProductC)表服务实现类
 *
 * @author makejava
 * @since 2020-10-10 14:30:09
 */
@Service("exportProductCService")
public class ExportProductCServiceImpl implements ExportProductCService {
    @Resource
    private ExportProductCMapper exportProductCMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param exportProductId 主键
     * @return 实例对象
     */
    @Override
    public ExportProductC queryById(String exportProductId) {
        return this.exportProductCMapper.queryById(exportProductId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<ExportProductC> queryAllByLimit(int offset, int limit) {
        return this.exportProductCMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param exportProductC 实例对象
     * @return 实例对象
     */
    @Override
    public ExportProductC insert(ExportProductC exportProductC) {
        this.exportProductCMapper.insert(exportProductC);
        return exportProductC;
    }

    /**
     * 修改数据
     *
     * @param exportProductC 实例对象
     * @return 实例对象
     */
    @Override
    public ExportProductC update(ExportProductC exportProductC) {
        this.exportProductCMapper.update(exportProductC);
        return this.queryById(exportProductC.getExportProductId());
    }

    /**
     * 通过主键删除数据
     *
     * @param exportProductId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String exportProductId) {
        return this.exportProductCMapper.deleteById(exportProductId) > 0;
    }
}