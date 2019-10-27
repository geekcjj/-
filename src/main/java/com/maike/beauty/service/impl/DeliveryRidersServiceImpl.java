package com.maike.beauty.service.impl;

import com.maike.beauty.entity.DeliveryRiders;
import com.maike.beauty.mapper.DeliveryRidersMapper;
import com.maike.beauty.service.IDeliveryRidersService;
import com.maike.beauty.utils.GenerateIdUtil;
import com.maike.beauty.utils.SequenceID;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author geekcjj
 * @since 2019-08-15
 */
@Service
public class DeliveryRidersServiceImpl extends ServiceImpl<DeliveryRidersMapper, DeliveryRiders> implements IDeliveryRidersService {
	public DeliveryRiders selectDeliveryRiderByUserAndPwed(Wrapper<DeliveryRiders> wrapper) {
		return baseMapper.selectOne(wrapper);
	}
	public Map<String,Object> selectNativePageDeliveryRider(int pageNum,int pageSize) {
		Map<String,Object> map = new HashMap<>();

        QueryWrapper<DeliveryRiders> queryWrapper =  new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");

        Page<DeliveryRiders> page = new Page<>(pageNum,pageSize);  // 查询第1页，每页返回5条
        IPage<DeliveryRiders> iPage = baseMapper.selectPage(page,queryWrapper);
        map.put("data", iPage);
		return map;
	}
	public PageInfo<DeliveryRiders> selectPageDeliveryRider(int pageNum,int pageSize){
		QueryWrapper<DeliveryRiders> queryWrapper =  new QueryWrapper<>();
        queryWrapper.orderByAsc("create_time");
		PageHelper.startPage(pageNum, pageSize);
	    List<DeliveryRiders> deliveryRiders = baseMapper.selectList(queryWrapper);
	    System.out.println("数据是："+deliveryRiders);
//	    List<UserDto> userDtos = new ArrayList<>();
//	    users.forEach(user -> {
//	        userDtos.add(dozerBeanMapper.map(user, UserDto.class));
//	    });
	    // 用PageInfo对结果进行包装
	    PageInfo<DeliveryRiders> pageInfo = new PageInfo<DeliveryRiders>(deliveryRiders);
	    return pageInfo;
	}
	@Override
	@Transactional
	public int addPerfectRder(DeliveryRiders deliveryRiders) {
		// TODO Auto-generated method stub
		int insertrider=baseMapper.updateById(deliveryRiders);
		return insertrider;
	}
	@Override
	public int loginByPhoneAndPwd(String phone,String password) {
		// TODO Auto-generated method stub
		int insertrider=baseMapper.selectCount(new QueryWrapper<DeliveryRiders>().eq("phone", phone).eq("password", password));
		return insertrider;
	}
	@Override
	@Transactional
	public int riderRegister(String phone,String password) {
		// TODO Auto-generated method stub
		DeliveryRiders riders=new DeliveryRiders();
		riders.setId(SequenceID.nextId());
		riders.setPhone(phone);
		riders.setPassword(password);
		int insertrider=baseMapper.insert(riders);
		return insertrider;
	}
	@Override
	public int updatePwd(String oldPwd,String phone, String pwd) {
		// TODO Auto-generated method stub
		DeliveryRiders deliveryRiders=new DeliveryRiders();
		deliveryRiders.setPhone(phone);
		deliveryRiders.setPassword(oldPwd);
		if(baseMapper.selectCount(new QueryWrapper<DeliveryRiders>().eq("phone",phone).eq("password", oldPwd))>0) {
			return baseMapper.update(deliveryRiders, new QueryWrapper<DeliveryRiders>().eq("phone", phone));
		}else {
			return 0;
		}
	}
}
