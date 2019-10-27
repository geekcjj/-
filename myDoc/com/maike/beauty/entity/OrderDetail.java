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
 * 订单详情表
 * </p>
 *
 * @author geekcjj
 * @since 2019-09-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OrderDetail对象", description="订单详情表")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单详情表ID")
    @TableId(value = "order_detail_id", type = IdType.INPUT)
    private String orderDetailId;

    @ApiModelProperty(value = "订单表ID")
    @TableField("order_id")
    private String orderId;

    @ApiModelProperty(value = "商品Id")
    @TableField("product_id")
    private String productId;

    @ApiModelProperty(value = "商品SKUID")
    @TableField("product_sku_id")
    private String productSkuId;

    @ApiModelProperty(value = "商品的规格参数")
    @TableField("product_specs")
    private String productSpecs;

    @ApiModelProperty(value = "商品名称")
    @TableField("product_name")
    private String productName;

    @ApiModelProperty(value = "购买商品数量")
    @TableField("product_num")
    private Integer productNum;

    @ApiModelProperty(value = "购买商品单价")
    @TableField("product_price")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "平均成本价格")
    @TableField("average_cost")
    private BigDecimal averageCost;

    @ApiModelProperty(value = "商品重量")
    @TableField("weight")
    private Float weight;

    @ApiModelProperty(value = "优惠分摊金额")
    @TableField("fee_money")
    private BigDecimal feeMoney;

    @ApiModelProperty(value = "仓库ID")
    @TableField("w_id")
    private Integer wId;

    @ApiModelProperty(value = "最后修改时间")
    @TableField("modified_time")
    private LocalDateTime modifiedTime;

    @ApiModelProperty(value = "判断商品是否为购买或租赁，0为购买，1为租赁")
    @TableField("is_rent")
    private Integer isRent;


}
