package com.hpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
//@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig2 {
    //可以通过Autowired装配，也可以直接参数带入
//    @Autowired
//    private JdbcProperties jdbcProperties;

/*    @Bean
    public DataSource dataSource(JdbcProperties pro){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(pro.getDriver());
        basicDataSource.setUrl(pro.getUrl());
        basicDataSource.setUsername(pro.getUsername());
        basicDataSource.setPassword(pro.getPassword());
        return  basicDataSource;
    }*/
}
