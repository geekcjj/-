package com.maike.beauty.service;

import com.maike.beauty.entity.DeliveryRiderOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author geekcjj
 * @since 2019-08-15
 */
public interface IDeliveryRiderOrderService extends IService<DeliveryRiderOrder> {

	/**
	 * 骑手接订单
	 * @param deliveryRiderOrder
	 * @return
	 */
	int insert(DeliveryRiderOrder deliveryRiderOrder);
	
	/**
	 * 每分钟更新骑手的位置信息
	 * @param currentPosition
	 * @return
	 */
	int updatePositionByOneMinute(String currentPosition);
	
	/**
	 * 获取骑手所有的订单信息
	 * @param riderId
	 * @return
	 */
	List<HashMap<String,Object>> getAllDeliveryOrderInfo(String status,String riderId);
	
	/**
	 * 获取骑手的某一个详细的订单的内容
	 * @param orderId
	 * @return
	 */
	List<Map<String,Object>> getOneDeliveryOrderInfo(String status,String orderId);
	
	/**
	 * 骑手送货成功后，点击完成订单
	 * @param deliveryRiderOrder
	 * @return
	 */
	int finishDeliveryOrder(DeliveryRiderOrder deliveryRiderOrder);
	
	/**
	 * 更新骑手订单的状态，属于正在准备，还是在配送中，还是配送成功
	 * @param deliveryRiderOrder
	 * @return
	 */
	int updateDeliverOrderStatus(DeliveryRiderOrder deliveryRiderOrder);
	
	/**
	 * 客户给骑手的订单评价星级：五星为满星
	 * @param orderId
	 * @param star
	 * @return
	 */
	int insertStar(String orderId,String star);
	
	/**
	 * 骑手的收入月结，下个月个月结上个月的工资，如果上个月没有则不结
	 * @param riderId
	 * @return
	 */
	String getOneMonthSalary(String riderId);
}
