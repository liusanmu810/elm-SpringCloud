package com.elm.service;

import java.util.List;

import com.elm.po.Orders;

public interface OrdersService {
    public int createOrders(Orders orders);

    public Orders getOrdersById(Integer orderId);

    public List<Orders> listOrdersByUserId(String userId);
}