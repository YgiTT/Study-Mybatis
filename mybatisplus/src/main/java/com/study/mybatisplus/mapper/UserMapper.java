package com.study.mybatisplus.mapper;

import com.study.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

/**
 * 基础mybatisplus,对实体类对应的表提供基础的CRUD
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    HashMap<String,Object> queryById(@Param("id")Long id);

    Page<User> pageSelect(@Param("page")Page<User> page, @Param("age") Integer age);


}
