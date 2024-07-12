package com.elm.controller;

import java.util.List;

import com.elm.po.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.elm.po.CommonResult;

import com.elm.service.FoodService;

@RestController
@RequestMapping("/FoodController")

public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/listFoodByBusinessId/{businessId}")
    public CommonResult<List> listFoodByBusinessId(@PathVariable("businessId") Integer businessId) throws Exception {
        List<Food> list = foodService.listFoodByBusinessId(businessId);
        return new CommonResult(200, "success(12001)", list);
    }
}