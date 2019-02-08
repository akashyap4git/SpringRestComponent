package com.ak4.config;

import com.ak4.exception.AppWebApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class DefaultJpaConfig {

    @Autowired
    private DataSourceConfig dataSourceConfig;

    @Autowired
    private AdapterConfig adapterConfig;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws AppWebApplicationException {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSourceConfig.mySqlDataSource());
        factoryBean.setPackagesToScan("com.ak4.entity");
        factoryBean.setJpaVendorAdapter(adapterConfig.mySqlAdapter());
        return factoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() throws AppWebApplicationException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
