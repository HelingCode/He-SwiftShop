package io.heling.swiftshop.starter.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/5/27 14:47
 * @description
 */
public class MyBatisConfig {

    @Value("${mybatis.scanpackages}")
    private String scanPackages;

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DruidDataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setTypeAliasesPackage(scanPackages);
        return sqlSessionFactory;
    }
}
