package com.elm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elm.mapper.FoodMapper;
import com.elm.po.Food;
import com.elm.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodMapper foodMapper;

    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        return foodMapper.listFoodByBusinessId(businessId);
    }
}