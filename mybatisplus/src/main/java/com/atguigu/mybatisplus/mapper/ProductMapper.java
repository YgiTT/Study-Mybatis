package com.atguigu.mybatisplus.mapper;

import com.atguigu.mybatisplus.pojo.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
public interface ProductMapper extends BaseMapper<Product> {


}
