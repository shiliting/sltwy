package com.slt.test.config;

//import org.eclipse.persistence.jpa.PersistenceProvider;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Created by Administrator on 2016/3/5.
 */
@Configuration
//@DependsOn("entityManagerFactory")
//@ImportResource(value = "classpath:spring-jpa.xml")
@EnableJpaRepositories(basePackages ={"com.slt.test.repository"})
@EnableTransactionManagement
//@EnableJpaAuditing
public class CoreConfig {

//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource=new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");
//        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/sltwy?useUnicode=true&amp;characterEncoding=UTF8");
//        return dataSource;
////        EmbeddedDatabaseBuilder builder=new EmbeddedDatabaseBuilder();
////        return builder.setType(EmbeddedDatabaseType.HSQL).build();
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
////        HibernateJpaVendorAdapter vendorAdapter=new HibernateJpaVendorAdapter();
////        vendorAdapter.setGenerateDdl(true);
//        LocalContainerEntityManagerFactoryBean factoryBean=new LocalContainerEntityManagerFactoryBean();
//        factoryBean.setDataSource(dataSource());
//        factoryBean.setPersistenceProvider(persistenceProvider());
//        factoryBean.setPackagesToScan("com.slt.test.entity");
//        factoryBean.setJpaDialect(jpaDialect());
//
//        Map<String,Object> map=new HashMap<>();
//        map.put("javax.persistence.schema-generation.database.action","create");
//        map.put("eclipselink.weaving","false");
//        map.put("eclipselink.logging.logger","org.eclipse.persistence.logging.CommonsLoggingLog");
//        map.put("eclipselink.logging.level","FINE");
//        factoryBean.setJpaPropertyMap(map);
//        return factoryBean;
//    }
//
//    /**
//     * jpa持久化供应者
//     * @return  eclipse的供应者实现对象
//     */
//    @Bean
//    public PersistenceProvider persistenceProvider(){
//        return new org.eclipse.persistence.jpa.PersistenceProvider();
//    }
//
//    /**
//     * jpa方言实现者
//     * @return  eclipseLink方言实现
//     */
//    private JpaDialect jpaDialect(){
//        return new EclipseLinkJpaDialect();
//    }
//
//
//    /**
//     * 事务处理器
//     * @return
//     */
//    @Bean(name = "transactionManager")
//    public PlatformTransactionManager transactionManager() {
//        EntityManagerFactory factory = entityManagerFactory().getObject();
//        return new JpaTransactionManager(factory);
//    }




}
