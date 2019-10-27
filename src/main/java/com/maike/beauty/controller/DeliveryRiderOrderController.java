package com.maike.beauty.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maike.beauty.mapper.DeliveryRiderOrderMapper;
import com.maike.beauty.utils.Result;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author geekcjj
 * @since 2019-08-15
 */
@RestController
@RequestMapping("/delivery-rider-order")
public class DeliveryRiderOrderController extends BaseController{
	@RequestMapping(value="/selectAllDeliveryOrder")
	public Result riderSelectDeliveryOrder(@RequestParam("status") String status,@RequestParam("ridersId") String riderId) {
		System.out.println(riderId);
		List<HashMap<String,Object>> riderDeliveryOrder=deliveryRiderOrderService.getAllDeliveryOrderInfo(status,riderId);
		System.out.println(riderDeliveryOrder);
		return Result.success(riderDeliveryOrder);
	}
}
