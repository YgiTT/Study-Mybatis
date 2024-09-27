package com.study.mybatisplus.mapper;

import com.study.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void test(){
        List<User> users1 = userMapper.selectList(null);
        System.out.println(users1);
    }
}