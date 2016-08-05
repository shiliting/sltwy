package com.slt.test.config;

//import org.eclipse.persistence.jpa.PersistenceProvider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Administrator on 2016/3/5.
 */
@Configuration
//@ImportResource(value = "classpath:spring-jpa.xml")
@EnableJpaRepositories(basePackages ={"com.slt.test.repository"})
@EnableTransactionManagement
@EnableJpaAuditing
public class CoreConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("dbuser");
        dataSource.setPassword("ddbbuusseerr");
        dataSource.setUrl("jdbc:mysql://mysql.flashymall.com:3307/sltwy?useUnicode=true&amp;characterEncoding=UTF8");
        return dataSource;
//        EmbeddedDatabaseBuilder builder=new EmbeddedDatabaseBuilder();
//        return builder.setType(EmbeddedDatabaseType.HSQL).build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
//        HibernateJpaVendorAdapter vendorAdapter=new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean factoryBean=new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPersistenceProvider(persistenceProvider());
        factoryBean.setPackagesToScan("com.slt.test.entity");
        factoryBean.setJpaDialect(jpaDialect());

        Map<String,Object> map=new HashMap<>();
        map.put("javax.persistence.schema-generation.database.action","create");
        map.put("eclipselink.weaving","false");
        map.put("eclipselink.logging.logger","org.eclipse.persistence.logging.CommonsLoggingLog");
        map.put("eclipselink.logging.level","FINE");
        factoryBean.setJpaPropertyMap(map);
        return factoryBean;
    }

    @Bean
    public PersistenceProvider persistenceProvider(){
        return new org.eclipse.persistence.jpa.PersistenceProvider();
    }

    @Bean
    public JpaDialect jpaDialect(){
        return new EclipseLinkJpaDialect();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() {
        EntityManagerFactory factory = entityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }
}
