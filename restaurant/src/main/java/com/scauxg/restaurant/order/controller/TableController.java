package com.scauxg.restaurant.order.controller;

import com.scauxg.restaurant.order.domain.Table;
import com.scauxg.restaurant.order.service.ITableService;
import com.scauxg.restaurant.common.ReturnResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Controller
@RequestMapping("/table")
public class TableController {
    private String prefix = "table";

    @Autowired
    private ITableService tableService;

    public String Table(){return prefix+"/table";}

    /**
     * 查询列表
     */
    @RequestMapping("/list")
    public String list(Table table, ModelMap modelMap) {
        List<Table> tables = tableService.selectTableList(table);
        modelMap.put("tables", tables);
        return prefix + "/table";
    }

    /**
     * 新增
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存
     */
//	@Log(title = "角色类别", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public ReturnResult addSave(Table table) {
        table.setTableState(0);
        return tableService.insertTable(table) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 修改
     */
    @GetMapping("/edit/{dinnerId}")
    public String edit(@PathVariable("dinnerId") Integer dinnerId, ModelMap mmap) {
        Table table = tableService.selectTableById(dinnerId);
        mmap.put("table", table);
        return prefix + "/edit";
    }

    /**
     * 修改保存
     */
//	@Log(title = "角色类别", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public ReturnResult editSave(Table table) {
        return tableService.updateTable(table) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 删除
     */
//	@Log(title = "角色类别", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public ReturnResult remove(Integer id) {
        return tableService.deleteTableById(id) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 删除列表
     */
//	@Log(title = "角色类别", businessType = BusinessType.DELETE)
    @PostMapping("/removeAll")
    @ResponseBody
    public ReturnResult removeAll(Integer[] ids) {
        return tableService.deleteTableByIds(ids) > 0 ? ReturnResult.success() : ReturnResult.error();
    }


}
