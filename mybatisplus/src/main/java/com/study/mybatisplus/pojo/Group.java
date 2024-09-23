package com.study.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author Ryan
 * @since 2023-08-04
 */
@Data
@TableName("t_group")
public class Group {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

}
