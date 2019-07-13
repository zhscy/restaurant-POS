package com.scauxg.restaurant.user.controller;

import com.scauxg.restaurant.common.ReturnResult;
import com.scauxg.restaurant.user.domain.Permission;
import com.scauxg.restaurant.user.domain.Role;
import com.scauxg.restaurant.user.service.IPermissionService;
import com.scauxg.restaurant.user.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/perms")
public class PermsController {
    private String prefix="perms";

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private IRoleService roleService;

    @GetMapping()
    public String perms() {
        return prefix + "/perms";
    }

    /**
     * 查询权限列表
     */
    @RequestMapping("/list")
    public String list(Permission permission, ModelMap modelMap) {
        List<Permission> permses = permissionService.selectPermissionList(permission);
        modelMap.put("permses",permses);
        return prefix + "/perms";
    }


    /**
     * 新增权限
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap) {
        List<Role> roles = this.roleService.selectRoleList(new Role());
        modelMap.put("roles", roles);
        return prefix + "/add";
    }

    /**
     * 新增保存权限
     */
//	@Log(title = "员工账号", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public ReturnResult addSave(Permission permission) {
        System.out.println("sdfsdfsdffffff" + permission);
        return permissionService.insertPerms(permission) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 修改权限
     */
    @GetMapping("/edit/{permsId}")
    public String edit(@PathVariable("permsId") Integer permsId, ModelMap mmap) {
        Permission perms = permissionService.selectPermissionById(permsId);
        System.out.println("================id"+permsId);
        List<Role> roles = this.roleService.selectRoleList(new Role());
        mmap.put("perms", perms);
        mmap.put("roles", roles);
        System.out.println("perms===================" + perms);
        return prefix + "/edit";
    }

    /**
     * 修改保存权限
     */
//	@Log(title = "员工账号", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public ReturnResult editSave(Permission permission) {
        return permissionService.updatePerms(permission) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 删除权限
     */
//	@Log(title = "员工账号", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public ReturnResult remove(Integer permsId) {
        return permissionService.deletePerms(permsId) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 批量删除权限
     */
	//@Log(title = "员工账号", businessType = BusinessType.DELETE)
    @PostMapping("/removeAll")
    @ResponseBody
    public ReturnResult removeAll(Integer[] ids) {
        return permissionService.deletePermsByIds(ids) > 0 ? ReturnResult.success() : ReturnResult.error();
    }




}
