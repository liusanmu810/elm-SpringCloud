package com.elm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import com.elm.po.Cart;

@Mapper
public interface CartMapper {
    List<Cart> listCart(Cart cart);

    @Insert("insert into cart values(null,#{foodId},#{businessId},#{userId},1)")
    public int saveCart(Cart cart);

    @Update("update cart set quantity=#{quantity} where foodId=#{foodId} and businessId=#{businessId} and userId=#{userId}")
    public int updateCart(Cart cart);

    public int removeCart(Cart cart);
}
