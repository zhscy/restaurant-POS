/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/22 15:53
 * History:
 */
package com.scauxg.restaurant.dictionary.service;

import com.scauxg.restaurant.dictionary.VO.DictDataVO;
import com.scauxg.restaurant.dictionary.domain.Data;

import java.util.List;

/**
 * 字典数据 服务层
 *
 * @author Yue
 * @create 2019/3/22
 * @since 1.0.0
 */
public interface IDataService {
    /**
     * 查询字典数据信息
     *
     * @param dictCode 字典数据ID
     * @return 字典数据信息
     */
    public DictDataVO selectDataById(Integer dictCode);

    /**
     * 查询字典数据列表
     *
     * @param data 字典数据信息
     * @return 字典数据集合
     */
    public List<DictDataVO> selectDataList(Data data);

    /**
     * 新增字典数据
     *
     * @param data 字典数据信息
     * @return 结果
     */
    public int insertData(Data data);

    /**
     * 修改字典数据
     *
     * @param data 字典数据信息
     * @return 结果
     */
    public int updateData(Data data);

    /**
     * 删除字典数据信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDataByIds(Integer[] ids);

}
