package com.elm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.elm.po.OrderDetailet;

@Mapper
public interface OrderDetailetMapper {
    public int saveOrderDetailetBatch(List<OrderDetailet> list);

    public List<OrderDetailet> listOrderDetailetByOrderId(Integer orderOd);
}