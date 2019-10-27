package com.maike.beauty.controller;
/**
 * @projectname BeautyDress
 * @author GEEKCJJ
 * @date 2019年8月15日 下午7:08:58
 * @description:
 *
 */

import org.springframework.beans.factory.annotation.Autowired;

import com.maike.beauty.service.IDeliveryRiderOrderPoolService;
import com.maike.beauty.service.IDeliveryRiderOrderService;
import com.maike.beauty.service.IDeliveryRidersService;
import com.maike.beauty.service.IRidersAppGalleryService;
import com.maike.beauty.service.ITestService;

public class BaseController {
	@Autowired
	public IDeliveryRidersService deliveryRidersService;
	@Autowired
	public IDeliveryRiderOrderService deliveryRiderOrderService;
	@Autowired
	public IRidersAppGalleryService appGalleryService;
	@Autowired
	public ITestService testService;
	@Autowired
	public IDeliveryRiderOrderPoolService deliveryRiderOrderPoolService;
}
