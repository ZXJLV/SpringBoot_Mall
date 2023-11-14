package com.seqq.springboot_mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootApplication
@MapperScan("com.seqq.springboot_mall.mapper")



public class SpringBootMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMallApplication.class, args);
    }

}
