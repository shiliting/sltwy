package com.slt.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Administrator on 2016/3/5.
 */
@Configuration
@ImportResource(value = "classpath:spring-jpa.xml")
@EnableJpaRepositories
public class CoreConfig {
}
