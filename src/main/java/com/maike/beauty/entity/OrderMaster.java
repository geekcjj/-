package com.maike.beauty.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单主表
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OrderMaster对象", description="订单主表")
public class OrderMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单ID")
    @TableId(value = "order_id", type = IdType.INPUT)
    private String orderId;

    @ApiModelProperty(value = "订单编号 yyyymmddnnnnnnnn")
    @TableField("order_sn")
    private Long orderSn;

    @ApiModelProperty(value = "下单人ID")
    @TableField("customer_id")
    private String customerId;

    @ApiModelProperty(value = "收货人姓名")
    @TableField("shipping_user")
    private String shippingUser;

    @ApiModelProperty(value = "省")
    @TableField("province")
    private Integer province;

    @ApiModelProperty(value = "市")
    @TableField("city")
    private Integer city;

    @ApiModelProperty(value = "区")
    @TableField("district")
    private Integer district;

    @ApiModelProperty(value = "地址")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "支付方式：1现金，2余额，3网银，4支付宝，5微信")
    @TableField("payment_method")
    private Integer paymentMethod;

    @ApiModelProperty(value = "订单金额")
    @TableField("order_money")
    private BigDecimal orderMoney;

    @ApiModelProperty(value = "优惠金额")
    @TableField("district_money")
    private BigDecimal districtMoney;

    @ApiModelProperty(value = "运费金额")
    @TableField("shipping_money")
    private BigDecimal shippingMoney;

    @ApiModelProperty(value = "支付金额")
    @TableField("payment_money")
    private BigDecimal paymentMoney;

    @ApiModelProperty(value = "快递公司名称")
    @TableField("shipping_comp_name")
    private String shippingCompName;

    @ApiModelProperty(value = "快递单号")
    @TableField("shipping_sn")
    private String shippingSn;

    @ApiModelProperty(value = "下单时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "发货时间")
    @TableField("shipping_time")
    private LocalDateTime shippingTime;

    @ApiModelProperty(value = "支付时间")
    @TableField("pay_time")
    private LocalDateTime payTime;

    @ApiModelProperty(value = "收货时间")
    @TableField("receive_time")
    private LocalDateTime receiveTime;

    @ApiModelProperty(value = "订单状态 0：未接单 1：已接单 2：已完成订单")
    @TableField("order_status")
    private Integer orderStatus;

    @ApiModelProperty(value = "订单积分")
    @TableField("order_point")
    private Integer orderPoint;

    @ApiModelProperty(value = "发票抬头")
    @TableField("invoice_time")
    private String invoiceTime;

    @ApiModelProperty(value = "最后修改时间")
    @TableField("modified_time")
    private LocalDateTime modifiedTime;

    @ApiModelProperty(value = "商家id")
    @TableField("supplier_id")
    private String supplierId;


}
