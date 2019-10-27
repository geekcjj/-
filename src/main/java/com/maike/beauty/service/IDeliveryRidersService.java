package com.maike.beauty.service;

import com.maike.beauty.entity.DeliveryRiders;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author geekcjj
 * @since 2019-08-15
 */
public interface IDeliveryRidersService extends IService<DeliveryRiders> {
	/**
	 * 登录
	 * @param wrapper
	 * @return
	 */
	int loginByPhoneAndPwd(String phone,String password);
	/**
	 * 原始分页
	 * @return
	 */
	Map<String,Object> selectNativePageDeliveryRider(int pageNum,int pageSize);
	/**
	 * pagehelper分页
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<DeliveryRiders> selectPageDeliveryRider(int pageNum,int pageSize);
	/**
	 * 骑手完善身份
	 * @param deliveryRiders
	 * @return
	 */
	int addPerfectRder(DeliveryRiders deliveryRiders);
	/**
	 * 骑手注册
	 * @param phone
	 * @param password
	 * @return
	 */
	int riderRegister(String phone,String password);
	/**
	 * 更改密码
	 * @param phone
	 * @param password
	 * @return
	 */
	int updatePwd(String oldPwd,String phone,String pwd);
}
