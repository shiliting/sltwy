package com.slt.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;

/**
 * Created by Administrator on 2016/8/8.
 */
//@Configuration
public class EntityManagerFactoryConfig {
    /**
     * jpa方言实现者
     * @return  eclipseLink方言实现
     */
    private JpaDialect jpaDialect(){
        return new EclipseLinkJpaDialect();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean factoryBean=new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("com.slt.test.entity");
        factoryBean.setJpaDialect(jpaDialect());
        factoryBean.setPersistenceUnitName("hotedu_dev");
        return factoryBean;
    }

    /**
     * 事务处理器
     * @return
     */
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() {
        EntityManagerFactory factory = entityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }
}
