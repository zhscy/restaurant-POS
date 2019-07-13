package com.scauxg.restaurant.dictionary.service;

import com.scauxg.restaurant.dictionary.VO.DictDataVO;
import com.scauxg.restaurant.dictionary.domain.Data;
import com.scauxg.restaurant.dictionary.mapper.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import com.ruoyi.common.support.Convert;

/**
 * 字典数据 服务层实现
 *
 * @author yue
 * @date 2019-03-23
 */
@Service
public class DataServiceImpl implements IDataService {
    @Autowired
    private DataMapper dataMapper;

    /**
     * 查询字典数据信息
     *
     * @param dictCode 字典数据ID
     * @return 字典数据信息
     */
    @Override
    public DictDataVO selectDataById(Integer dictCode) {
        return dataMapper.selectDataById(dictCode);
    }

    /**
     * 查询字典数据列表
     *
     * @param data 字典数据信息
     * @return 字典数据集合
     */
    @Override
    public List<DictDataVO> selectDataList(Data data) {
        return dataMapper.selectDataList(data);
    }

    /**
     * 新增字典数据
     *
     * @param data 字典数据信息
     * @return 结果
     */
    @Override
    public int insertData(Data data) {
        return dataMapper.insertData(data);
    }

    /**
     * 修改字典数据
     *
     * @param data 字典数据信息
     * @return 结果
     */
    @Override
    public int updateData(Data data) {
        return dataMapper.updateData(data);
    }

    /**
     * 删除字典数据对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDataByIds(Integer[] ids) {
        return dataMapper.deleteDataByIds(ids);
    }

}
