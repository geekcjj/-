package com.maike.beauty.service.impl;

import com.maike.beauty.entity.DeliveryRiderOrderPool;
import com.maike.beauty.mapper.DeliveryRiderOrderPoolMapper;
import com.maike.beauty.service.IDeliveryRiderOrderPoolService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-11
 */
@Service
public class DeliveryRiderOrderPoolServiceImpl extends ServiceImpl<DeliveryRiderOrderPoolMapper, DeliveryRiderOrderPool> implements IDeliveryRiderOrderPoolService {

	@Resource
	private DeliveryRiderOrderPoolMapper deliveryRiderOrderPoolMapper;
	@Override
	public List<Map<String, Object>> getAllDeliveryOrderPool() {
		// TODO Auto-generated method stub
		return deliveryRiderOrderPoolMapper.riderListOrderDeliveryListPool();
	}

}
