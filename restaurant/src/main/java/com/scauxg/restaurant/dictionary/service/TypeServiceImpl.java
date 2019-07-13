package com.scauxg.restaurant.dictionary.service;

import com.scauxg.restaurant.dictionary.domain.Type;
import com.scauxg.restaurant.dictionary.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典类型 服务层实现
 *
 * @author yue
 * @date 2019-03-23
 */
@Service
public class TypeServiceImpl implements ITypeService {
    @Autowired
    private TypeMapper typeMapper;

    /**
     * 查询字典类型信息
     *
     * @param dictId 字典类型ID
     * @return 字典类型信息
     */
    @Override
    public Type selectTypeById(Integer dictId) {
        return typeMapper.selectTypeById(dictId);
    }

    /**
     * 查询字典类型列表
     *
     * @param type 字典类型信息
     * @return 字典类型集合
     */
    @Override
    public List<Type> selectTypeList(Type type) {
        return typeMapper.selectTypeList(type);
    }

    /**
     * 新增字典类型
     *
     * @param type 字典类型信息
     * @return 结果
     */
    @Override
    public int insertType(Type type) {
        return typeMapper.insertType(type);
    }

    /**
     * 修改字典类型
     *
     * @param type 字典类型信息
     * @return 结果
     */
    @Override
    public int updateType(Type type) {
        return typeMapper.updateType(type);
    }

    /**
     * 删除字典类型对象
     *
     * @param id 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTypeById(Integer id) {
        return typeMapper.deleteTypeById(id);
    }

    /**
     * 删除字典类型对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTypeByIds(Integer[] ids) {
        return typeMapper.deleteTypeByIds(ids);
    }

}
