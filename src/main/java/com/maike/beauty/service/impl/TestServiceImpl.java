package com.maike.beauty.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maike.beauty.entity.Test;
import com.maike.beauty.mapper.TestMapper;
import com.maike.beauty.service.ITestService;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fj
 * @since 2019-08-12
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

}
