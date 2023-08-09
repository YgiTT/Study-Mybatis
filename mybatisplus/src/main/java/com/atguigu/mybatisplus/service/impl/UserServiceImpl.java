package com.atguigu.mybatisplus.service.impl;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import com.atguigu.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Author Ryan Yan
 * @Since 2023/8/1 16:55
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void getTest(){
        HashMap<String, Object> stringObjectHashMap = this.baseMapper.queryById(1L);
        System.out.println(stringObjectHashMap);
    }

//    private void test(){
//        Long count = this.baseMapper.selectCount(null);
//    }


}
