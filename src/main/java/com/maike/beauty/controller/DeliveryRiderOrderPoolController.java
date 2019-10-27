package com.maike.beauty.controller;


import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.maike.beauty.utils.Result;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-11
 */
@RestController
@RequestMapping("/deliveryRiderOrderPool")
public class DeliveryRiderOrderPoolController extends BaseController{
	@RequestMapping(value="/getAllDeliveryOrderList")
	public Result getAllDeliveryOrderList() {
		List<Map<String,Object>> deliveryOrderList= deliveryRiderOrderPoolService.getAllDeliveryOrderPool();
		if(deliveryOrderList==null) {
			return Result.error("当前订单池内没有订单!");
		}
		return Result.success(deliveryOrderList);
	}
}
