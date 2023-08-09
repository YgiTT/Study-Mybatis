package com.atguigu.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * Date:2022/2/15
 * Author:ybc
 * Description:
 */
@Data
@TableName("t_product")
public class Product {

    private Long id;

    private String name;

    private Integer price;

    //标识乐观锁版本号字段
    @Version
    private Integer version;
}
