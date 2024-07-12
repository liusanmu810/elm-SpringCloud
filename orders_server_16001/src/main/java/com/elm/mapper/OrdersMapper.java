package com.elm.mapper;

import com.elm.po.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdersMapper {

    @Insert("insert into orders(orderId,userId,businessId,orderDate,orderTotal,daId,orderState) values(#{orderId},#{userId},#{businessId},#{orderDate},#{orderTotal},#{daId},0)")
    public int saveOrders(Orders orders);

    public Orders getOrdersById(Integer orderId);

    public List<Orders> listOrdersByUserId(String userId);

}
