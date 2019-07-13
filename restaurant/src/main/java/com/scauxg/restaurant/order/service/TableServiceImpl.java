package com.scauxg.restaurant.order.service;

import com.scauxg.restaurant.order.domain.Table;
import com.scauxg.restaurant.order.mapper.TableMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class TableServiceImpl implements ITableService{

    @Autowired
    private TableMapper tableMapper;

    /**
     * 查询员工账号信息
     *
     * @param dinnerId 员工账号ID
     * @return 员工账号信息
     */
    @Override
    public Table selectTableById(Integer dinnerId) { return tableMapper.selectTableById(dinnerId); }

    /**
     * 查询员工账号列表
     *
     * @param table 员工账号信息
     * @return 员工账号集合
     */
    @Override
    public List<Table> selectTableList(Table table) {
        return tableMapper.selectTableList(table);
    }

    /**
     * 新增员工账号
     *
     * @param table 员工账号信息
     * @return 结果
     */
    @Override
    public int insertTable(Table table) {
        return tableMapper.insertTable(table);
    }

    /**
     * 修改员工账号
     *
     * @param table 员工账号信息
     * @return 结果
     */
    @Override
    public int updateTable(Table table) {
        return tableMapper.updateTable(table);
    }

    /**
     * 批量删除员工账号对象
     *
     * @param id 需要删除的员工账号ID
     * @return 结果
     */
    @Override
    public int deleteTableById(Integer id) {
        return tableMapper.deleteTableById(id);
    }

    /**
     * 批量删除员工账号对象
     *
     * @param ids 需要删除的员工账号ID
     * @return 结果
     */
    @Override
    public int deleteTableByIds(Integer[] ids) {
        return tableMapper.deleteTableByIds(ids);
    }

}
