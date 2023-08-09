package com.atguigu.mybatisplus.pojo;

import com.atguigu.mybatisplus.enums.SexEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 实体类对应的table表
 * 若不是使用TableName,默认使用类名
 * @Author Ryan Yan
 * @Since 2023/8/1 10:27
 */
@Data
@TableName("user")
public class User {

    /**
     * 、@TableId注解的value属性用于指定主键的字段
     * 、@TableId注解的type属性设置主键生成策略
     * 设置：自增
     *      前提：数据库需要已经设置了自增
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    private  String userName;

    private Integer age;

    private  String email;

    private SexEnum sex;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer isDeleted;



}
