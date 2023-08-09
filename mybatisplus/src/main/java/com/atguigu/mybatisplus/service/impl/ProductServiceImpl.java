package com.atguigu.mybatisplus.service.impl;

import com.atguigu.mybatisplus.pojo.Product;
import com.atguigu.mybatisplus.mapper.ProductMapper;
import com.atguigu.mybatisplus.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ryan
 * @since 2023-08-04
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
