package com.study.mybatisplus.myTest;

import com.study.mybatisplus.pojo.User;
import com.study.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Ryan Yan
 * @Since 2023/8/1 17:03
 */
@SpringBootTest
public class MyServiceTest {

    @Autowired
    private UserService userService;


    @Test
    public  void test01(){
        long count = userService.count();
        System.out.println(count);
        userService.getTest();
    }

    @Test
    public void insertTest(){
        User user = new User();
        user.setAge(12);
        user.setUserName("YYF123");
        userService.save(user);
    }

}
