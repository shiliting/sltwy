package com.slt.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * Created by slt on 2016/3/5.
 */
@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private Environment environment;


    public void configureViewResolvers(ViewResolverRegistry registry) {
        super.configureViewResolvers(registry);
        registry.viewResolver(viewResolver());

        registry.jsp();
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        SpringTemplateEngine engine = new SpringTemplateEngine();
        ServletContextTemplateResolver rootTemplateResolver = new ServletContextTemplateResolver();
        rootTemplateResolver.setPrefix("/");
        rootTemplateResolver.setSuffix(".html");
        if (environment.acceptsProfiles("test") || environment.acceptsProfiles("develop"))
            rootTemplateResolver.setCacheable(false);
        rootTemplateResolver.setCharacterEncoding("UTF-8");

        engine.setTemplateResolver(rootTemplateResolver);
        resolver.setTemplateEngine(engine);
//        resolver.setOrder(99);
        resolver.setOrder(2147483647 + 10);
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }
}
