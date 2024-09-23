package com.study.mybatisplus.service.impl;

import com.study.mybatisplus.pojo.Product;
import com.study.mybatisplus.mapper.ProductMapper;
import com.study.mybatisplus.service.ProductService;
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
