package com.atguigu.mybatisplus.service.impl;

import com.atguigu.mybatisplus.pojo.Group;
import com.atguigu.mybatisplus.mapper.GroupMapper;
import com.atguigu.mybatisplus.service.GroupService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  数据源为：slave_1
 * </p>
 *
 * @author Ryan
 * @since 2023-08-04
 */
@Service
@DS("slave_1")
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements GroupService {

}
