/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.user.controller;

import com.scauxg.restaurant.common.ReturnResult;
import com.scauxg.restaurant.user.domain.Role;
import com.scauxg.restaurant.user.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import com.ruoyi.framework.aspectj.lang.annotation.Log;

/**
 * 菜品类别 信息操作处理
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    private String prefix = "role";

    @Autowired
    private IRoleService roleService;

    @GetMapping()
    public String category() {
        return prefix + "/role";
    }

    /**
     * 查询角色类别列表
     */
    @RequestMapping("/list")
    public String list(Role role, ModelMap modelMap) {
        List<Role> roles = roleService.selectRoleList(role);
        modelMap.put("roles", roles);
        return prefix + "/role";
    }

    /**
     * 新增角色类别
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存角色类别
     */
//	@Log(title = "角色类别", businessType = BusinessType.INSERT)

    @PostMapping("/add")
    @ResponseBody
    public ReturnResult addSave(Role role) {
        return roleService.insertRole(role) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 修改角色类别
     */
    @GetMapping("/edit/{roleId}")
    public String edit(@PathVariable("roleId") Integer roleId, ModelMap mmap) {
        Role role = roleService.selectRoleById(roleId);
        mmap.put("role", role);
        return prefix + "/edit";
    }

    /**
     * 修改保存角色类别
     */
//	@Log(title = "角色类别", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public ReturnResult editSave(Role role) {
        return roleService.updateRole(role) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 删除角色类别
     */
//	@Log(title = "角色类别", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public ReturnResult remove(Integer id) {
        return roleService.deleteRoleById(id) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 删除角色类别
     */
//	@Log(title = "角色类别", businessType = BusinessType.DELETE)
    @PostMapping("/removeAll")
    @ResponseBody
    public ReturnResult removeAll(Integer[] ids) {
        return roleService.deleteRoleByIds(ids) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    @PostMapping("/test")
    @ResponseBody
    public String test() {
        return "OK";
    }

}
