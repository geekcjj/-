package com.maike.beauty.service;

import com.maike.beauty.entity.DeliveryRiderOrderPool;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-11
 */
public interface IDeliveryRiderOrderPoolService extends IService<DeliveryRiderOrderPool> {
	List<Map<String,Object>> getAllDeliveryOrderPool();
}
