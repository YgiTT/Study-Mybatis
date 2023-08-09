package com.atguigu.mybatisplus.myTest;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @Author Ryan Yan
 * @Since 2023/8/2 15:17
 */
@SpringBootTest
public class MyWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert(){
        User user = new User();
        user.setUserName("yyf");
        user.setAge(21);
        user.setEmail("1223@4455");
        userMapper.insert(user);
    }

    @Test
    public void queryTest(){
        //条件查询
        //column为表的字段名
        //默认"and"连接
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("user_name","yyf")
                .between("age",20,30)
                .isNotNull("email");
        List<User> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
        System.out.println("=======================");
        //order by
        QueryWrapper<User> userQueryWrapper1 = new QueryWrapper<>();
        userQueryWrapper1.orderByDesc("age")
                .orderByDesc("id");
        List<User> users1 = userMapper.selectList(userQueryWrapper1);
        System.out.println(users1);
        System.out.println("==================");
    }

    @Test
    public void query2Test(){
        //条件优先执行
        //用户名中包含有a并且（年龄大于20或邮箱为null）
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("user_name","Jo")
                .and(column-> column.gt("age",20).or().isNull("email"));
        List<User> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
        System.out.println("==============");
        //指定返回的字段
        QueryWrapper<User> userQueryWrapper2 = new QueryWrapper<>();
        userQueryWrapper2.select("age","user_name");
        List<Map<String, Object>> maps = userMapper.selectMaps(userQueryWrapper2);
        maps.forEach(System.out::println);
        System.out.println("==================================");
        //子查询
        //查询id小于等于100的用户信息
        QueryWrapper<User> userQueryWrapper3 = new QueryWrapper<>();
        userQueryWrapper3.inSql("id","select id from user where age < 30");
        List<User> users1 = userMapper.selectList(userQueryWrapper3);
        System.out.println(users1);
        //、使用 condition
        //当判断为true,才添加指定条件
        String userName = "";
        QueryWrapper<User> userQueryWrapper1 = new QueryWrapper<>();
        userQueryWrapper1.like( !userName.isEmpty(),"user_name",userName);
        List<User> users2 = userMapper.selectList(userQueryWrapper1);
        System.out.println(users2);
    }

    /**
     * LambdaQueryWrapper
     */
    @Test
    public void query3Test(){
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (user_name LIKE ? AND age <= ?)
        String username = "y";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(!username.isEmpty(), User::getUserName, username)
                .ge(ageBegin != null, User::getAge, ageBegin)
                .le(ageEnd != null, User::getAge, ageEnd);
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void updateTest(){
        //根据条件更新
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_name","yyf");
        User user = new User();
        user.setAge(18);
        int update = userMapper.update(user, userQueryWrapper);
    }


    /**
     * LambdaUpdateWrapper
     */
    @Test
    public void updateTest2(){
        //、使用updateWrapper更新
        String userName = "yyf123";
        int age = 18;
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        //条件
        userUpdateWrapper.eq(age > 0,"age",age);
        //set
        userUpdateWrapper.set("user_name",userName).set("age",age);
        //update
        int update = userMapper.update(null, userUpdateWrapper);
        //、使用LambdaUpdateWrapper 更新
        LambdaUpdateWrapper<User> lambdaUpdate = new LambdaUpdateWrapper<>();
        String userName2 = "yyf1234";
        int age2 = 18;
        //
        lambdaUpdate.eq( age2 > 0,User::getAge,age2);
        //
//        lambdaUpdate.set(User::getUserName,userName2);
        lambdaUpdate.set(User::getUserName,userName2);
        userMapper.update(null,lambdaUpdate);

    }

    @Test
    public void deleteTest(){
        //删除邮箱地址为null的用户信息
        //UPDATE t_user SET is_deleted=1 WHERE is_deleted=0 AND (email IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int result = userMapper.delete(queryWrapper);
        System.out.println("result:"+result);
    }

}
