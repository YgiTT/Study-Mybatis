package com.study.mybatisplus.myTest;

import com.study.mybatisplus.mapper.UserMapper;
import com.study.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Ryan Yan
 * @Since 2023/8/1 11:05
 */
@SpringBootTest
public class MyBaseMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
        userMapper.deleteById(1686268518839939079L);
        List<User> users1 = userMapper.selectList(null);
        System.out.println(users1);
    }

    /**
     * insert
     */
    @Test
    public void test02(){
        User user = new User();
        user.setUserName("yyf");
        user.setEmail("123@yyf123");
        user.setAge(233);
        int insert = userMapper.insert(user);
        System.out.println(user.getId());
    }

    /**
     * delete
     */
    @Test
    public void test03(){
        //通过id实现删除
        userMapper.deleteById(1L);
        //通过多个id实现批量删除
        //DELETE FROM user WHERE id IN ( ? , ? , ? )
        userMapper.deleteBatchIds( Arrays.asList(1L,2L,3L,4L,5L));
         //根据map集合中所设置的条件删除用户信息
        //DELETE FROM user WHERE name = ? AND age = ?
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","yyf");
        map.put("age",233);
        userMapper.deleteByMap(map);
    }


    /**
     * update
     */
    @Test
    public void updateTest(){
        User user = new User();
        user.setId(1L);
        user.setUserName("LongDD");
        user.setAge(null);
        //根据实体id修改属性,若属性为空则忽略
        userMapper.updateById(user);
    }


    @Test
    public void selectTest(){
        //通过id查询用户信息
        //SELECT id,name,age,email FROM user WHERE id=?
        User user = userMapper.selectById(1L);
        System.out.println(user);
        //根据多个id查询多个用户信息
        //SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        List<User> users2 = userMapper.selectBatchIds(list);
        users2.forEach(System.out::println);
        //根据map集合中的条件查询用户信息
        //SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jack");
        map.put("age", 20);
        List<User> users3 = userMapper.selectByMap(map);
        users3.forEach(System.out::println);
        //查询所有数据
        //SELECT id,name,age,email FROM user
        List<User> users4 = userMapper.selectList(null);
        users4.forEach(System.out::println);
        //自定义查询
        HashMap<String, Object> resultMap = userMapper.queryById(1L);
        System.out.println(resultMap);
    }
}
