package com.scauxg.restaurant.order.service;

import com.scauxg.restaurant.order.domain.Table;
import java.util.List;

public interface ITableService {
    /**
     * 查询员工账号户信息
     *
     * @param dinnerId 桌子ID
     * @return 桌子信息
     */
    public Table selectTableById(Integer dinnerId);

    /**
     * 查询员工账号列表
     *
     * @param table 桌子信息
     * @return 员工账号户集合
     */
    public List<Table> selectTableList(Table table);

    /**
     * 新增员工账号
     *
     * @param table 员工账号信息
     * @return 结果
     */
    public int insertTable(Table table);

    /**
     * 修改员工账号
     *
     * @param table 员工账号信息
     * @return 结果
     */
    public int updateTable(Table table);

    /**
     * 批量删除员工账号信息
     *
     * @param id 需要删除的员工账号ID
     * @return 结果
     */
    public int deleteTableById(Integer id);

    /**
     * 批量删除员工账号信息
     *
     * @param ids 需要删除的员工账号ID
     * @return 结果
     */
    public int deleteTableByIds(Integer[] ids);
}
