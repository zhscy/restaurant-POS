package com.scauxg.restaurant.order.mapper;

import com.scauxg.restaurant.order.domain.Table;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TableMapper {

    /**
     * 查询角色信息
     *
     * @param dinnerId 桌子ID
     * @return 角色信息
     */
    public Table selectTableById(Integer dinnerId);

    /**
     * 查询角色列表
     *
     * @param table 桌子信息
     * @return 菜品类别集合
     */
    public List<Table> selectTableList(Table table);

    /**
     * 新增角色
     *
     * @param table 桌子信息
     * @return 结果
     */
    public int insertTable(Table table);

    /**
     * 修改角色
     *
     * @param table 桌子信息
     * @return 结果
     */
    public int updateTable(Table table);

    /**
     * 删除角色
     *
     * @param dinnerId 桌子ID
     * @return 结果
     */
    public int deleteTableById(Integer dinnerId);

    /**
     * 批量删除角色
     *
     * @param Ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTableByIds(Integer[] Ids);
}
