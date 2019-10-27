package com.maike.beauty.service.impl;

import com.maike.beauty.entity.DeliveryRiderOrder;
import com.maike.beauty.mapper.DeliveryRiderOrderMapper;
import com.maike.beauty.service.IDeliveryRiderOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.HashMap;
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
 * @since 2019-08-15
 */
@Service
public class DeliveryRiderOrderServiceImpl extends ServiceImpl<DeliveryRiderOrderMapper, DeliveryRiderOrder> implements IDeliveryRiderOrderService {
	@Resource
	public DeliveryRiderOrderMapper deliveryRiderOrderMapper;
	@Override
	public int insert(DeliveryRiderOrder deliveryRiderOrder) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePositionByOneMinute(String currentPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HashMap<String,Object>> getAllDeliveryOrderInfo(String status,String riderId) {
		// TODO Auto-generated method stub
		List<HashMap<String,Object>> allDeliverOrder=deliveryRiderOrderMapper.riderSelectAllDeliveryOrder(status,riderId);
		//HashMap<String,Object> order_item=deliveryRiderOrderMapper.riderSelectDeliveryOrderItem(isRent, orderId);
		return allDeliverOrder;
	}

	@Override
	public List<Map<String,Object>> getOneDeliveryOrderInfo(String status,String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int finishDeliveryOrder(DeliveryRiderOrder deliveryRiderOrder) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateDeliverOrderStatus(DeliveryRiderOrder deliveryRiderOrder) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertStar(String orderId, String star) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getOneMonthSalary(String riderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
