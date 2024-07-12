package com.elm.controller;

import com.elm.feign.FoodFeignClient;
import com.elm.po.Business;
import com.elm.po.CommonResult;
import com.elm.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/BusinessController")

public class BusinessController {
    @Autowired
    private BusinessService businessService;
    @Autowired
    private FoodFeignClient foodFeignClient;

    @GetMapping("/listBusinessByOrderTypeId/{orderTypeId}")
    public CommonResult<List> listBusinessByOrderTypeId(@PathVariable("orderTypeId") Integer orderTypeId) throws Exception {
        List<Business> list = businessService.listBusinessByOrderTypeId(orderTypeId);
        return new CommonResult(200, "success(10300)", list);
    }

    @GetMapping("/getBusinessById/{businessId}")
    public CommonResult<Business> getBusinessById(@PathVariable("businessId") Integer businessId) throws Exception {


        Business business = businessService.getBusinessById(businessId);
        //在商家微服务中调用食品微服务
        CommonResult<List> result = foodFeignClient.listFoodByBusinessId(businessId);
        System.out.printf(result.getMessage());
        //如果食品微服务返回降级响应，那么就返回空集合
        if (result.getCode() == 200) {
            business.setFoodList(result.getResult());
            return new CommonResult(200, "success", business);
        } else {
            business.setFoodList(new ArrayList());
            return new CommonResult(403, "食品服务异常 食品列表为空", business);
        }

    }
}