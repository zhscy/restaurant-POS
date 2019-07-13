/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/5/6 9:16
 * History:
 */
package com.scauxg.restaurant.pos;

import com.alibaba.fastjson.JSON;
import com.scauxg.restaurant.common.ReturnResult;
import com.scauxg.restaurant.dictionary.domain.Type;
import com.scauxg.restaurant.food.VO.MenuVO;
import com.scauxg.restaurant.food.domain.Category;
import com.scauxg.restaurant.food.domain.Menu;
import com.scauxg.restaurant.food.service.ICategoryService;
import com.scauxg.restaurant.food.service.IMenuService;
import com.scauxg.restaurant.order.VO.ItemVO;
import com.scauxg.restaurant.order.VO.OrderVO;
import com.scauxg.restaurant.order.domain.Item;
import com.scauxg.restaurant.order.domain.Order;
import com.scauxg.restaurant.order.domain.Payment;
import com.scauxg.restaurant.order.domain.Table;
import com.scauxg.restaurant.order.service.IItemService;
import com.scauxg.restaurant.order.service.IOrderService;
import com.scauxg.restaurant.order.service.IPaymentService;
import com.scauxg.restaurant.order.service.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * posAPI整合
 *
 * @author Yue
 * @create 2019/5/6
 * @since 1.0.0
 */
@RestController
@RequestMapping("/pos")
public class POSController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IMenuService menuService;

    @Autowired
    private ITableService tableService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IItemService itemService;

    @Autowired
    private IPaymentService paymentService;

    @PostMapping("/getCategoryList")
    public List<Category> getCategoryList() {
        List<Category> categoryList = this.categoryService.selectCategoryList(new Category());
        return categoryList;
    }

    @PostMapping("/getMenuList")
    public List<MenuVO> getMenuList(@RequestBody Category category) {
        Menu menu = new Menu();
        menu.setMenuCategory(category.getCtgId());
        List<MenuVO> menuList = this.menuService.selectMenuList(menu);
        return menuList;
    }

    @PostMapping("/getTableList")
//    public List<Table> getTableList(@RequestBody Table table) {
    public List<Table> getTableList() {
        List<Table> tableList = this.tableService.selectTableList(new Table());
        return tableList;
    }

    @PostMapping("/getItemList")
    public List<ItemVO> getItemList(@RequestBody Item item) {
        return this.itemService.selectItemList(item);
    }

    /**
     * 提交订单，挂单
     * @param models
     * @return
     */
    @PostMapping("/submitOrder")
    public ReturnResult submitOrder(@RequestBody Map<String, Object> models) {
        // 转换格式获取对象参数
        Order order = JSON.parseObject(JSON.toJSONString(models.get("order")), Order.class);
        List<ItemVO> itemList = JSON.parseArray(JSON.toJSONString(models.get("itemList")),  ItemVO.class);

        if (order.getTableId() == null) {
            return ReturnResult.error("请输入餐桌号");
        }
        order.setOrderTime(new Date());

        // 计算订单总价
        double orderTotalPrice = 0;
        for (ItemVO item : itemList) {
            orderTotalPrice += item.getTotalPrice();
        order.setOrderTotalPrice(orderTotalPrice);
        }

//
//        setTableState(order.getTableId(), 1);
//        Iterator itemIterator = itemList.iterator();
//        while (itemIterator.hasNext()) {
//
//        }
        try {
            // 先生成订单
            orderService.insertOrder(order);

            // 设置返回的订单id，插入明细
            for (Item insertItem : itemList) {
                insertItem.setOrderId(order.getOrderId());
                itemService.insertItem(insertItem);
            }
        } catch (Exception e) {
            e.printStackTrace();

            return ReturnResult.error("挂单失败，请重试！");
        }

        return ReturnResult.success("挂单成功，订单总价为" + orderTotalPrice);
    }

    /**
     *
     * @param models
     * @return
     */
    @PostMapping("/pay")
    public ReturnResult pay(@RequestBody Map<String, Object> models) {
        // 转换格式获取对象参数
        Order order = JSON.parseObject(JSON.toJSONString(models.get("order")), Order.class);
        Payment payment = JSON.parseObject(JSON.toJSONString(models.get("payment")), Payment.class);
        System.out.println("payment" + payment);
        if (payment.getPayWay() == null && payment.getPayWay().equals("")) {
            return ReturnResult.error("支付失败，请选择支付方式");
        }
        if (payment.getPayTotal() < payment.getPayActual()) {
            return ReturnResult.error("支付失败，付款金额错误");
        }

        try {
            paymentService.insertPayment(payment);
            System.out.println("payment==" + payment);
            order.setPayState(payment.getPayId());
            System.out.println("order===" + order);
            orderService.updateOrder(order);
//            setTableState(order.getTableId(), 0);
            return ReturnResult.success("支付成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnResult.error("支付失败");
        }
    }

    /**
     * 订单
     * @return
     */
    @PostMapping("/payOrderList")
    public List<OrderVO> payOrderList(@RequestBody Order order) {
        List<OrderVO> orderList = this.orderService.selectPayOrderList(order);
        return orderList;
    }

    void setTableState(Integer tableId, Integer tableState) {
        Table table = tableService.selectTableById(tableId);
        table.setTableState(tableState);
        tableService.updateTable(table);
    }


    @PostMapping("/test")
    public Order test() {
        System.out.println("test");
        Order order = new Order();
        order.setOrderTime(new Date());
        order.setOrderTotalPrice(555.00);
        order.setTableId(4);
//        this.orderService.insertOrder(order);
        return order;
    }
    @PostMapping("/testRequestBody")
    public Category testRequestBody(@RequestBody List<Table> tables,@RequestBody Category category) {
        for (Table table : tables) {
            System.out.println("table=====" + table);
        }
        System.out.println("------------分割------------------");
                System.out.println("category" + category);

        return category;
    }
    @PostMapping("/testMultiParam")
    public ReturnResult testMultiParam(@RequestBody Map<String, Object> models) {
//        Category cc = (Category) models.get("category");
//        System.out.println("cc===" + cc);
        Category category = JSON.parseObject(JSON.toJSONString(models.get("category")), Category.class);
        System.out.println("category===" + category);

        Table table = JSON.parseObject(JSON.toJSONString(models.get("table")), Table.class);
        System.out.println("table===" + table);

            System.out.println("-----------------------------------------------------------");
        List<Type> typeList = JSON.parseArray(JSON.toJSONString(models.get("typeList")),  Type.class);
        for (Type type : typeList) {
            System.out.println("type--" + type);
        }
        return ReturnResult.success();
    }

    @GetMapping("/get")
    public ReturnResult getTest() {
//        System.out.println("=======get==========");
        return ReturnResult.success("get");
    }

    @PostMapping("getData")
    public ReturnResult postDataTest() {
        System.out.println("---------------");
        return ReturnResult.success("getData");
    }

}
