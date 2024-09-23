package com.study.mybatisplus.myTest;

import com.study.mybatisplus.mapper.ProductMapper;
import com.study.mybatisplus.mapper.UserMapper;
import com.study.mybatisplus.pojo.Product;
import com.study.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author Ryan Yan
 * @Since 2023/8/3 14:22
 */
@SpringBootTest
public class MyPlusPluginsTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    /**
     * 分页插件
     */
    @Test
    public void pageTest(){
        //分页查询
        Page<User> userPage = new Page<>(1, 1);
        Page<User> userPage1 = userMapper.selectPage(userPage,null);
        List<User> records = userPage1.getRecords();
        long total = userPage1.getTotal();
        System.out.println(records);
        System.out.println(total);

        //自定义分页查询
        Page<User> userPage2 = new Page<>(1, 2);
        Page<User> userIPage = userMapper.pageSelect(userPage2, 10);
        List<User> records2 = userIPage.getRecords();
        long total2 = userIPage.getTotal();
        System.out.println(records2);
        System.out.println(total2);

    }

    /**
     * 乐观锁插件
     * 模拟小明修改价格有延迟，小王先获取到未更新之前的价格并修改的并发问题，导致价格修改不对。
     * 通过加乐观锁防止
     */
    @Test
    public void OptimisticLockTest(){
        //小明查询价格
        Product productLi = productMapper.selectById(1L);
        System.out.println("小李查询的商品价格："+productLi.getPrice());
        //小王查询价格
        Product productWang = productMapper.selectById(1L);
        System.out.println("小王查询的商品价格："+productWang.getPrice());
        //小明加50
        productLi.setPrice(productLi.getPrice()+50);
        int i1 = productMapper.updateById(productLi);
        if(i1 == 0){
            System.out.println("修改失败请重试");
        }
        //小王减50
        productWang.setPrice(productWang.getPrice() - 50);
        int i2 = productMapper.updateById(productWang);
        if(i2 == 0){
            System.out.println("修改失败请重试");
        }
        //查询价格
        Product product = productMapper.selectById(1L);
        System.out.println("价格"+product.getPrice());
    }

}
