package com.study.mybatisplus.myTest;

import com.study.mybatisplus.pojo.Group;
import com.study.mybatisplus.pojo.User;
import com.study.mybatisplus.service.GroupService;
import com.study.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Ryan Yan
 * @Since 2023/8/4 15:05
 */
@SpringBootTest
public class MyDataSourceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

//    @Test
//    public void test(){
//        Group group = new Group();
//        group.setName("开发组");
//        groupService.save(group);
//
//    }


    @Test
    public void test2(){
        Group groups = groupService.getById(1L);
        System.out.println(groups);

        User users = userService.getById(1L);
        System.out.println(users);

    }

}
