package com.deer.managementPlatform.dao;

import com.deer.managementPlatform.entity.ExportProductC;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (ExportProductC)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-10 14:30:09
 */
public interface ExportProductCMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param exportProductId 主键
     * @return 实例对象
     */
    ExportProductC queryById(String exportProductId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ExportProductC> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param exportProductC 实例对象
     * @return 对象列表
     */
    List<ExportProductC> queryAll(ExportProductC exportProductC);

    /**
     * 新增数据
     *
     * @param exportProductC 实例对象
     * @return 影响行数
     */
    int insert(ExportProductC exportProductC);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ExportProductC> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ExportProductC> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ExportProductC> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<ExportProductC> entities);

    /**
     * 修改数据
     *
     * @param exportProductC 实例对象
     * @return 影响行数
     */
    int update(ExportProductC exportProductC);

    /**
     * 通过主键删除数据
     *
     * @param exportProductId 主键
     * @return 影响行数
     */
    int deleteById(String exportProductId);

}