package com.maike.beauty.entity;

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
 * @since 2019-09-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DeliveryRiderOrderPool对象", description="")
public class DeliveryRiderOrderPool implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "商家接收的订单")
    @TableField("order_id")
    private String orderId;

    @ApiModelProperty(value = "消费者的经纬，判断与小店的距离")
    @TableField("customer_add_ll")
    private String customerAddLl;

    @ApiModelProperty(value = "消费者的中文详细四肢")
    @TableField("customer_add")
    private String customerAdd;

    @ApiModelProperty(value = "店家的经纬地址")
    @TableField("supplier_add_ll")
    private String supplierAddLl;

    @ApiModelProperty(value = "店家的中文详细地址")
    @TableField("supplier_add")
    private String supplierAdd;

    @ApiModelProperty(value = "订单创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;


}
