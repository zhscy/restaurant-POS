/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/22 17:25
 * History:
 */
package com.scauxg.restaurant.dictionary.controller;

import com.scauxg.restaurant.common.ReturnResult;
import com.scauxg.restaurant.dictionary.VO.DictDataVO;
import com.scauxg.restaurant.dictionary.domain.Data;
import com.scauxg.restaurant.dictionary.domain.Type;
import com.scauxg.restaurant.dictionary.service.IDataService;
import com.scauxg.restaurant.dictionary.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import com.ruoyi.framework.aspectj.lang.annotation.Log;

/**
 * 字典数据 信息操作处理
 *
 * @author Yue
 * @create 2019/3/22
 * @since 1.0.0
 */
@Controller
@RequestMapping("/dictData")
public class DataController {
    private String prefix = "dictData";

    @Autowired
    private IDataService dataService;

    @Autowired
    private ITypeService typeService;

    @GetMapping()
    public String data() {
        return prefix + "/data";
    }

    /**
     * 查询字典数据列表
     */
    @RequestMapping("/list/{dictDataType}")
    public String list(@PathVariable("dictDataType")Integer dictDataType, Data data, ModelMap modelMap) {
        data.setDictDataType(dictDataType);
        List<DictDataVO> datas = dataService.selectDataList(data);
        modelMap.put("datas", datas);
        return prefix + "/data";
    }


    /**
     * 新增字典数据
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap) {
        List<Type> types = this.typeService.selectTypeList(new Type());
        modelMap.put("types", types);
        return prefix + "/add";
    }

    /**
     * 新增保存字典数据
     */
//	@Log(title = "字典数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public ReturnResult addSave(Data data) {
        return dataService.insertData(data) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 修改字典数据
     */
    @RequestMapping("/edit/{dictCode}")
    public String edit(@PathVariable("dictCode") Integer dictCode, ModelMap modelMap) {
        Data data = dataService.selectDataById(dictCode);
        modelMap.put("data", data);
        return prefix + "/edit";
    }

    /**
     * 修改保存字典数据
     */
//	@Log(title = "字典数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public ReturnResult editSave(Data data) {
        return dataService.updateData(data) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 删除字典数据
     */
//	@Log(title = "字典数据", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public ReturnResult remove(Integer[] ids) {
        return dataService.deleteDataByIds(ids) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

}
