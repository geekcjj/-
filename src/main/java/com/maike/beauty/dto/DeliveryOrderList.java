package com.maike.beauty.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.maike.beauty.entity.OrderDetail;
import com.maike.beauty.entity.OrderLease;

import lombok.Data;

/**
 * @projectname BeautyDress
 * @author GEEKCJJ
 * @date 2019年9月13日 上午2:18:59
 * @description:
 *
 */
@Data
public class DeliveryOrderList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//骑手配送的订单号
	private String deliverOrderid;
	//商品的订单号
	private String orderId;
	//商品的订单状态
	private String orderStatus;
	//配送订单评价星级
	private String deliveryStar;
	//配送订单评价内容
	private String deliveryComment;
	//配送订单的单价
	private String deliveryPrice;
	//商家名称
	private String supplierName;
	//商家Logo
	private String supplierLogo;
	//商家id
	private String supplierId;
	//开始地址,为商家的地址
	private String startAdd;
	//开始地址的经纬度
	private String startAddLl;
	//目标的地址,为目标的地址
	private String targetAdd;
	//目标的地址经纬度
	private String targetAddLl;
	//当前骑手的经纬度
	private String currentAddLl;
	//骑手的Id
	private String ridersId;
	//骑手的电话
	private String riderPhone;
	//骑手的姓名
	private String riderName;
	//消费者的姓名
	private String customerName;
	//消费者的电话
	private String customerPhone;
	//消费者的ID
	private String customerId;
	//订单商品的信息
	private List<Map<String,Object>> orderItem;
	//private List<OrderDetail> orderDetail;
	//private List<OrderLease> orderLease;
	//配送订单创建时间
	private LocalDateTime deliverOrderCreateTime;
	//商品订单创建时间
	private LocalDateTime orderCreateTime;
	//配送订单完成时间
	private LocalDateTime orderFinishTime;
}
