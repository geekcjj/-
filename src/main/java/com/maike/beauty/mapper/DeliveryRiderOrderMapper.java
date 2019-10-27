package com.maike.beauty.mapper;

import com.maike.beauty.entity.DeliveryRiderOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-26
 */
public interface DeliveryRiderOrderMapper extends BaseMapper<DeliveryRiderOrder> {
	List<HashMap<String,Object>> riderSelectAllDeliveryOrder(@Param("status")String status,@Param("ridersId")String riderId);
	List<HashMap<String,Object>> riderSelectDeliveryOrderItem(@Param("isRent")String isRent,@Param("orderId")String orderId);
}
