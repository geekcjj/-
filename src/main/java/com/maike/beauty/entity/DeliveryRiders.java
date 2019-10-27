package com.maike.beauty.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @author geekcjj
 * @since 2019-08-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DeliveryRiders implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /**
     * 姓名
     */
    @TableField("realname")
    private String realname;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 手机
     */
    @TableField("phone")
    private String phone;

    /**
     * 邮件
     */
    @TableField("email")
    private String email;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 验证token
     */
    @TableField("token")
    private String token;

    /**
     * 身份证号
     */
    @TableField("identity_id")
    private String identityId;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;
    /*
     * 用户头像
     */
    @TableField("user_pic")
    private String userPic;
    /*
     * 工作城市
     */
    @TableField("work_city")
    private String workCity;

}
