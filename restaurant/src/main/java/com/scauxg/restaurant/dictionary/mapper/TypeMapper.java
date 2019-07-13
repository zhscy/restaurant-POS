/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/22 15:48
 * History:
 */
package com.scauxg.restaurant.dictionary.mapper;

import com.scauxg.restaurant.dictionary.domain.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 字典类型 数据层
 *
 * @author Yue
 * @create 2019/3/22
 * @since 1.0.0
 */
@Repository
public interface TypeMapper {
    /**
     * 查询字典类型信息
     *
     * @param dictId 字典类型ID
     * @return 字典类型信息
     */
    public Type selectTypeById(Integer dictId);

    /**
     * 查询字典类型列表
     *
     * @param type 字典类型信息
     * @return 字典类型集合
     */
    public List<Type> selectTypeList(Type type);

    /**
     * 新增字典类型
     *
     * @param type 字典类型信息
     * @return 结果
     */
    public int insertType(Type type);

    /**
     * 修改字典类型
     *
     * @param type 字典类型信息
     * @return 结果
     */
    public int updateType(Type type);

    /**
     * 删除字典类型
     *
     * @param dictId 字典类型ID
     * @return 结果
     */
    public int deleteTypeById(Integer dictId);

    /**
     * 批量删除字典类型
     *
     * @param dictIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTypeByIds(Integer[] dictIds);

}