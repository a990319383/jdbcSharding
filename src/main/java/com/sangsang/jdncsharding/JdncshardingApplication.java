package com.sangsang.jdncsharding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootConfiguration
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})//排除DataSourceConfiguratrion
@EnableTransactionManagement(proxyTargetClass = true)   //开启事物管理功能
public class JdncshardingApplication {
    public static void main(String[] args) {
        SpringApplication.run(JdncshardingApplication.class, args);
    }
}
