package com.elm.controller;

import com.elm.po.CommonResult;
import com.elm.po.Orders;
import com.elm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/OrdersController")

public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/createOrders/{userId}/{businessId}/{orderTotal}")
    public CommonResult<Integer> createOrders(@PathVariable("userId") String userId, @PathVariable("businessId") Integer businessId, @PathVariable("orderTotal") Double orderTotal) throws Exception {
        Orders orders = new Orders();
        Random random = new Random();
        int min = 1000;
        int max = 9999;
        int orderId =  random.nextInt(max - min + 1) + min;
        orders.setOrderId(orderId);
        orders.setUserId(userId);
        orders.setBusinessId(businessId);
        orders.setOrderTotal(orderTotal);
        ordersService.createOrders(orders);
        return new CommonResult(200, "success（10601）", orderId);
    }

    @GetMapping("/getOrdersById/{orderId}")
    public CommonResult<Orders> getOrdersById(@PathVariable("orderId") Integer orderId) throws Exception {
        Orders orders = ordersService.getOrdersById(orderId);
        return new CommonResult(200, "success（10601）", orders);
    }

    @GetMapping("/listOrdersByUserId/{userId}")
    public CommonResult<List> listOrdersByUserId(@PathVariable("userId") String userId) throws Exception {
        List<Orders> list = ordersService.listOrdersByUserId(userId);
        return new CommonResult(200, "success（10601）", list);
    }
}