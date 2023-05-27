package io.heling.swiftshop.starter.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/5/27 14:44
 * @description
 */
public class JdbcConfig {
    @Value("${jdbc.initialSize}")
    private int initialSize;
    @Value("${jdbc.minIdle}")
    private int minIdle;
    @Value("${jdbc.maxActive}")
    private int maxActive;
    @Value("${jdbc.maxWait}")
    private int maxWait;
    @Value("${jdbc.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${jdbc.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;
    @Value("${jdbc.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${jdbc.testOnReturn}")
    private boolean testOnReturn;
    @Value("${jdbc.validationQuery}")
    private String validationQuery;
    @Value("${jdbc.dbType}")
    private String dbType;
    @Value("${jdbc.filters}")
    private String filters;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DruidDataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setDbType(dbType);
        dataSource.setFilters(filters);
        return dataSource;
    }
}

