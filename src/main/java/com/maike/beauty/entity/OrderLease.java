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
 * 
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OrderLease对象", description="")
public class OrderLease implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "订单Id")
    @TableField("order_id")
    private String orderId;

    @ApiModelProperty(value = "商品sku")
    @TableField("product_sku_id")
    private String productSkuId;

    @ApiModelProperty(value = "租赁价格")
    @TableField("ren_price")
    private BigDecimal renPrice;

    @ApiModelProperty(value = "租赁天数")
    @TableField("rent_days")
    private Integer rentDays;

    @ApiModelProperty(value = "租赁开始时间")
    @TableField("rent_start_date")
    private LocalDateTime rentStartDate;

    @ApiModelProperty(value = "租赁结束时间")
    @TableField("rent_end_date")
    private LocalDateTime rentEndDate;

    @ApiModelProperty(value = "押金")
    @TableField("deposit")
    private BigDecimal deposit;

    @ApiModelProperty(value = "租金总额")
    @TableField("rent_total_price")
    private BigDecimal rentTotalPrice;

    @ApiModelProperty(value = "租赁数量")
    @TableField("rent_num")
    private Integer rentNum;

    @ApiModelProperty(value = "用户ID")
    @TableField("customer_id")
    private String customerId;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "支付状态 0：待提交  1：待付款  2：待收货 3：完成订单 4：取消订单")
    @TableField("pay_status")
    private Integer payStatus;

    @ApiModelProperty(value = "收货地址")
    @TableField("address_info")
    private String addressInfo;

    @ApiModelProperty(value = "收货人姓名")
    @TableField("receiver_name")
    private String receiverName;

    @ApiModelProperty(value = "收货人号码")
    @TableField("receiver_phone")
    private String receiverPhone;

    @ApiModelProperty(value = "商品id")
    @TableField("product_id")
    private String productId;


}
