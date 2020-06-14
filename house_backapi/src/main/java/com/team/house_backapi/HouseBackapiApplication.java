package com.team.house_backapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication

//添加扫描mybatis的dao层接口，生成实现类
@MapperScan(value = "com.team.house_backapi.mapper")

@ServletComponentScan(basePackages = {"com.team.house_backapi.filter"})
public class HouseBackapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseBackapiApplication.class, args);
    }

}
