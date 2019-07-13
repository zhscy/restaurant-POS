package com.scauxg.restaurant.order;

import com.scauxg.restaurant.order.domain.Table;
import com.scauxg.restaurant.order.mapper.TableMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TableCURDTest {

    @Autowired
    TableMapper tableMapper;

    @Test
    public void createTable(){
        Table table = new Table();
        table.setDinnerNumber(102);
        table.setDinnerType("8人桌");
        table.setTableState(0);
        tableMapper.insertTable(table);
    }

    @Test
    public void updateTable(){
        Table table = new Table();
        table.setDinnerId(2);
        table.setTableState(1);
        tableMapper.updateTable(table);
    }

    @Test
    public void readTable(){ System.out.println(tableMapper.selectTableById(1)); }

    @Test
    public void readTableList() {
        Table table = new Table();
        table.setTableState(0);
        System.out.println(tableMapper.selectTableList(table));
    }

    @Test
    public void deleteTable(){
        int result = tableMapper.deleteTableById(2);
        System.out.println("Result==========" + result);
    }

    @Test
    public void deleteTableList(){
        Integer ids[] = {3,4};
        System.out.println("result=========" + tableMapper.deleteTableByIds(ids));
    }

}
