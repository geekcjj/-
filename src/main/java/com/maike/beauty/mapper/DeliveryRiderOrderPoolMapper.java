package com.maike.beauty.mapper;

import com.maike.beauty.entity.DeliveryRiderOrderPool;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-26
 */
public interface DeliveryRiderOrderPoolMapper extends BaseMapper<DeliveryRiderOrderPool> {
	List<Map<String,Object>> riderListOrderDeliveryListPool();
}
