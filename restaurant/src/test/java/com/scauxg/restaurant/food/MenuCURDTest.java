/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/4/5 0:22
 * History:
 */
package com.scauxg.restaurant.food;

import com.scauxg.restaurant.food.VO.MenuVO;
import com.scauxg.restaurant.food.domain.Menu;
import com.scauxg.restaurant.food.mapper.MenuMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 菜品测试
 *
 * @author Yue
 * @create 2019/4/5
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuCURDTest {

    @Autowired
    MenuMapper menuMapper;

    @Test
    public void readTest() {
        MenuVO menuVO = menuMapper.selectMenuById(1);
        System.out.println("result============" + menuVO);
    }

    @Test
    public void readListTest() {
        List<MenuVO> menuVOs = menuMapper.selectMenuList(new Menu());
        System.out.println("result=========" + menuVOs);
    }
}
