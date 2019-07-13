/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/22 17:43
 * History:
 */
package com.scauxg.restaurant.dictionary.controller;

import com.scauxg.restaurant.common.ReturnResult;
import com.scauxg.restaurant.dictionary.domain.Type;
import com.scauxg.restaurant.dictionary.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import com.ruoyi.framework.aspectj.lang.annotation.Log;

/**
 * 字典类型 信息操作处理
 *
 * @author Yue
 * @create 2019/3/22
 * @since 1.0.0
 */
@Controller
@RequestMapping("/dictType")
public class TypeController {
    private String prefix = "dictType";

    @Autowired
    private ITypeService typeService;

    @GetMapping()
    public String type() {
        return prefix + "/type";
    }

    /**
     * 查询字典类型列表
     */
/*    @PostMapping("/list")
    @ResponseBody*/
    @RequestMapping("/list")
    public String list(Type type, ModelMap modelMap) {
        List<Type> types = typeService.selectTypeList(type);
        modelMap.put("types", types);
        return prefix + "/type";
    }


    /**
     * 新增字典类型
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存字典类型
     */
//    @Log(title = "字典类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public ReturnResult addSave(Type type) {
        System.out.println("============" + type);
        return typeService.insertType(type) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 修改字典类型
     */
    @RequestMapping("/edit/{dictId}")
    public String edit(@PathVariable("dictId") Integer dictId, ModelMap mmap) {
        Type type = typeService.selectTypeById(dictId);
        mmap.put("type", type);
        return prefix + "/edit";
    }

    /**
     * 修改保存字典类型
     */
//    @Log(title = "字典类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public ReturnResult editSave(Type type) {
        try {
            return typeService.updateType(type) > 0 ? ReturnResult.success() : ReturnResult.error();
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnResult.error("发生错误!");
        }
    }

    /**
     * 删除字典类型
     */
//    @Log(title = "字典类型", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public ReturnResult remove(Integer id) {
        try {
            return typeService.deleteTypeById(id) > 0 ? ReturnResult.success() : ReturnResult.error();
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnResult.error("内有字典类型数据，无法删除");
        }
    }

    /**
     * 删除字典类型
     */
//    @Log(title = "字典类型", businessType = BusinessType.DELETE)
    @PostMapping("/removeAll")
    @ResponseBody
    public ReturnResult removeAll(Integer[] ids) {
        return typeService.deleteTypeByIds(ids) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

}
