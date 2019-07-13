package com.scauxg.restaurant.order;

import com.scauxg.restaurant.order.domain.Item;
import com.scauxg.restaurant.order.VO.ItemVO;
import com.scauxg.restaurant.order.mapper.ItemMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemCURTest {

    @Autowired
    ItemMapper itemMapper;

    @Test
    public void createItem(){
        Item item = new Item();
        item.setItemHandle(" ");
        item.setItemMenuId(2);
        item.setItemAmount(2);
        item.setUnitPrice(42.0);
        item.setTotalPrice(84.0);
        itemMapper.insertItem(item);
    }

    @Test
    public void updateItem(){
        Item item = new Item();
        item.setItemId(1);
        item.setUnitPrice(40.0);
        item.setTotalPrice(80.0);
        itemMapper.updateItem(item);
    }

    @Test
    public void readItem(){
        Item item = new Item();
        item.setOrderId(3);
        List<ItemVO> items = itemMapper.selectItemList(item);
        for (Item it :
                items) {
            System.out.println(it);
        }

    }


}
