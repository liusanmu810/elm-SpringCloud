package com.elm.feign;

import org.springframework.stereotype.Component;
import com.elm.po.CommonResult;

@Component
public class FoodFeignClientCallBack implements FoodFeignClient {
    @Override
    public CommonResult listFoodByBusinessId(Integer businessId) {
        //返回降级响应（食品信息返回null）
        return new CommonResult(403, "食品服务异常，调用失败", null);
    }
}