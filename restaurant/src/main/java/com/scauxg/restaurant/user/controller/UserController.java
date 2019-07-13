/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.user.controller;

import com.scauxg.restaurant.common.ReturnResult;
import com.scauxg.restaurant.dictionary.VO.DictDataVO;
import com.scauxg.restaurant.dictionary.domain.Data;
import com.scauxg.restaurant.dictionary.domain.Type;
import com.scauxg.restaurant.dictionary.service.IDataService;
import com.scauxg.restaurant.dictionary.service.ITypeService;
import com.scauxg.restaurant.user.VO.UserVO;
import com.scauxg.restaurant.user.domain.Role;
import com.scauxg.restaurant.user.domain.User;
import com.scauxg.restaurant.user.service.IRoleService;
import com.scauxg.restaurant.user.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import com.ruoyi.framework.aspectj.lang.annotation.Log;


/**
 * 员工账号 信息操作处理
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private String prefix = "user";

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private ITypeService typeService;

    @Autowired
    private IDataService dataService;

    @GetMapping()
    public String user() {
        return prefix + "/user";
    }

    /**
     * 查询员工账号列表
     */
    @RequestMapping("/list")
    public String list(User user, ModelMap modelMap) {
        List<UserVO> users = userService.selectUserList(user);

/*
        // 查询数据字典
        Type type = new Type();
        type.setDictType("user_sex");
        try {
            type = typeService.selectTypeList(type).get(0);
        } catch (Exception e) {
            System.out.println("获取字典类型失败");
            e.printStackTrace();
        }

        Data data = new Data();
        data.setDictDataType(type.getDictId());
        List<DictDataVO> list = dataService.selectDataList(data);

        for (DictDataVO dataVO : list) {
            System.out.println("sex===============" + list);
        }
        List<String> sexes = new ArrayList<>();
        for (User u : users) {
            System.out.println("user=====" + u);
            for (Data d : list) {
                System.out.println("---------------------------------------");
                System.out.println("data====" + d);
                if (d.getDictValue().equals(u.getUserSex())) {
                    System.out.println("------------赋值-------------");
                    sexes.add(d.getDictLabel());
                }
            }
        }
        for (String s : sexes) {
            System.out.println("用户性别列表" + s);
        }
*/


        modelMap.put("users", users);
//        modelMap.put("sexes", sexes);

        return prefix + "/user";
    }


    /**
     * 新增员工账号
     */
    @RequiresPermissions("user:modify")
    @RequiresRoles("admin")
    @GetMapping("/add")
    public String add(ModelMap modelMap) {
        List<Role> roles = this.roleService.selectRoleList(new Role());

        List<DictDataVO> dictDatas = this.getDictDatas();

        modelMap.put("roles", roles);
        modelMap.put("dictDatas", dictDatas);
        return prefix + "/add";
    }

    /**
     * 新增保存员工账号
     */
//	@Log(title = "员工账号", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public ReturnResult addSave(User user) {
//        System.out.println("addSave------user===========" + user);
        return userService.insertUser(user) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 修改员工账号
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Integer userId, ModelMap mmap) {
        User user = userService.selectUserById(userId);
        List<Role> roles = this.roleService.selectRoleList(new Role());
        List<DictDataVO> dictDatas = this.getDictDatas();

        mmap.put("user", user);
        mmap.put("roles", roles);
        mmap.put("dictDatas", dictDatas);
        return prefix + "/edit";
    }

    /**
     * 修改保存员工账号
     */
//	@Log(title = "员工账号", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public ReturnResult editSave(User user) {
//        System.out.println("editSave------user=============" + user);
        return userService.updateUser(user) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 删除员工账号
     */
//	@Log(title = "员工账号", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public ReturnResult remove(Integer id) {
        return userService.deleteUserById(id) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 批量删除员工账号
     */
//	@Log(title = "员工账号", businessType = BusinessType.DELETE)
    @PostMapping("/removeAll")
    @ResponseBody
    public ReturnResult removeAll(Integer[] ids) {
        return userService.deleteUserByIds(ids) > 0 ? ReturnResult.success() : ReturnResult.error();
    }

    /**
     * 查询数据字典
     * @return
     */
    public List<DictDataVO> getDictDatas() {
        Type type = new Type();
        type.setDictType("user_sex");
        try {
            type = typeService.selectTypeList(type).get(0);
        } catch (Exception e) {
            System.out.println("获取字典类型失败");
            e.printStackTrace();
        }
        Data data = new Data();
        data.setDictDataType(type.getDictId());

        return dataService.selectDataList(data);
    }

}
