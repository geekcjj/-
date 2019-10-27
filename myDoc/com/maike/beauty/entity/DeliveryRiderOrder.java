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
 * @since 2019-09-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DeliveryRiderOrder对象", description="")
public class DeliveryRiderOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @TableField("riders_id")
    private String ridersId;

    @TableField("order_id")
    private String orderId;

    @ApiModelProperty(value = "商家的详细地址")
    @TableField("start_add")
    private String startAdd;

    @ApiModelProperty(value = "商家的经纬度地址")
    @TableField("start_add_ll")
    private String startAddLl;

    @ApiModelProperty(value = "目的地址:消费者的详细地址")
    @TableField("target_add")
    private String targetAdd;

    @ApiModelProperty(value = "消费者的经纬地址")
    @TableField("target_add_ll")
    private String targetAddLl;

    @ApiModelProperty(value = "当前骑手的地址，每2分钟更新一次，当到达客户地址配送完成后，更新为客户地址")
    @TableField("current_add_ll")
    private String currentAddLl;

    @ApiModelProperty(value = "开始时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "完成时间")
    @TableField("finish_time")
    private LocalDateTime finishTime;

    @ApiModelProperty(value = "订单状态，0为失败，1为配送中，2为配送成功、即完成,3为其他情况")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "配送评价星级，5星为满星")
    @TableField("delivery_star")
    private Integer deliveryStar;

    @ApiModelProperty(value = "评价内容")
    @TableField("delivery_comment")
    private String deliveryComment;

    @ApiModelProperty(value = "配送价格按照公里数：1-5公里是4元，5-10公里是7元；10公里以上11元")
    @TableField("delivery_price")
    private BigDecimal deliveryPrice;


}
