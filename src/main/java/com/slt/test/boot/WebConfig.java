package com.slt.test.boot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 包含配置
 * Created by slt on 2016/3/5.
 */
@Configuration
@ComponentScan(basePackages = "com.slt.test.config")
public class WebConfig {
}
