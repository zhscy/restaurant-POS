/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/23 21:48
 * History:
 */
package com.scauxg.restaurant.dict;

import com.scauxg.restaurant.dictionary.domain.Data;
import com.scauxg.restaurant.dictionary.domain.Type;
import com.scauxg.restaurant.dictionary.mapper.DataMapper;
import com.scauxg.restaurant.dictionary.service.ITypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 数据字典测试
 *
 * @author Yue
 * @create 2019/3/23
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DictTest {
    @Autowired
    DataMapper dataMapper;

    @Autowired
    ITypeService typeMapper;

    @Test
    public void createTypeTest() {
        Type type = new Type();
        type.setDictName("tt");
        type.setDictType("tt");
        typeMapper.insertType(type);
        typeMapper.insertType(type);
    }


    @Test
    public void readTypeTest() {
        System.out.println(typeMapper.selectTypeById(1));
    }

    @Test
    public void readTypeListTest() {
        Type type = new Type();
        System.out.println(typeMapper.selectTypeList(type));
    }

    @Test
    public void updateTypeTest() {
        Type type = new Type();
        type.setDictId(3);
        type.setDictName("test");
        type.setDictType("test");
        type.setDictRemark("");
        System.out.println("restult====" + typeMapper.updateType(type));

    }

    @Test
    public void deleteTypeTest() {
        System.out.println("result====" + typeMapper.deleteTypeById(3));
    }

    @Test
    public void deleteTypeListTest() {
        Integer[] ids = {5, 6};
        System.out.println("result====" + typeMapper.deleteTypeByIds(ids));
    }

    @Test
    public void createDataTest() {
        Data data1 = new Data();
        data1.setDictLabel("tt1");
        data1.setDictValue(0);
        data1.setDictDataType(3);
        dataMapper.insertData(data1);

        Data data2 = new Data();
        data2.setDictLabel("tt2");
        data2.setDictValue(1);
        data2.setDictDataType(3);
        dataMapper.insertData(data2);

        Data data3 = new Data();
        data3.setDictLabel("tt3");
        data3.setDictValue(2);
        data3.setDictDataType(3);
        dataMapper.insertData(data3);

    }

    @Test
    public void readDataTest() {
        System.out.println(dataMapper.selectDataList(new Data()));
    }



}
