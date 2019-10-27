package com.maike.beauty.service.impl;

import com.maike.beauty.entity.OrderDetail;
import com.maike.beauty.mapper.OrderDetailMapper;
import com.maike.beauty.service.IOrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单详情表 服务实现类
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-26
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDetailService {

}
