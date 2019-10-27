package com.maike.beauty.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author fj
 * @since 2019-08-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品名称
     */
    @TableField("commo_name")
    private String commoName;

    /**
     * 单价 分
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 库存
     */
    @TableField("stocks")
    private Integer stocks;

    @TableField("picture_url")
    private String pictureUrl;

    /**
     * 状态 0-下架 1-上架
     */
    @TableField("status")
    private Integer status;

    @TableField("parent_catalog")
    private Integer parentCatalog;

    @TableField("child_catalog")
    private Integer childCatalog;

    /**
     * 作者
     */
    @TableField("author")
    private String author;

    /**
     * 出版社
     */
    @TableField("press")
    private String press;

    @TableField("pub_date")
    private String pubDate;

    @TableField("preface")
    private String preface;

    @TableField("commo_catalog")
    private String commoCatalog;

    @TableField("isbn")
    private String isbn;

    @TableField("commo_lable")
    private String commoLable;

    @TableField("score")
    private String score;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("modiy_time")
    private LocalDateTime modiyTime;


}
