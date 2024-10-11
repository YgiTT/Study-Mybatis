package com.study.mybatisplus.autoGenerator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

/**
 * 逆向工程生成代码
 * https://baomidou.com/guides/new-code-generator/
 * @Author Ryan Yan
 * @Since 2024/10/11 17:08
 */
public class AutoGeneratorTest1 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/study_lease?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2b8";
        String username = "root";
        String password = "p2ssword";

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> builder
                        .author("RyanYan")
                        .outputDir("Y:\\Yan\\greate")
                        .commentDate("yyyy-MM-dd")
                )
                .packageConfig(builder -> builder
                        .parent("com.study.mybatisplus")
                        .entity("entity")
                        .mapper("mapper")
                        .service("service")
                        .serviceImpl("service.impl")
                        .xml("mapper.xml")
                )
                .strategyConfig(builder -> builder
                        .entityBuilder()
                        .enableLombok()
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }





}
