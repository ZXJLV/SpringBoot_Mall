package com.seqq.springboot_mall.mapper;

import com.seqq.springboot_mall.entity.Productorder;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest    // 只启动JPA组件不启动全环境
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class ProductorderMapperTest {

    @Test
    void selectProductordersByDate() {

        SqlSession sqlSession = MybatisMapper.getSqlSession();
        ProductorderMapper mapper = sqlSession.getMapper(ProductorderMapper.class);
        List<Productorder> productorderList = mapper.selectProductordersByDate("2018-05-03 16:13:14", "2022-05-03 16:13:14");
        for (Productorder productorder : productorderList) {
            System.err.println("\u001B[33m" + productorder + "\u001B[0m");
        }

    }
}