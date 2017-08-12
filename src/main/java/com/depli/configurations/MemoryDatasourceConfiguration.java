package com.depli.configurations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lahiru Pathirage
 * @since 8/12/17
 */


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "memoryDatasourceEntityManagerFactory",
        transactionManagerRef = "memoryDatasourceTransactionManager",
        basePackages = "com.depli.repositories.memory"
)
public class MemoryDatasourceConfiguration {

    @Value("${memory.datasource.hibernate.hbm2ddl.auto}")
    private String hibernateAutoMode;

    @Value("${memory.datasource.hibernate.dialect}")
    private String hibernateDialect;

    @Bean
    @ConfigurationProperties(prefix = "memory.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "memoryDatasourceEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(
            EntityManagerFactoryBuilder entityManagerFactoryBuilder
    ) {
        return entityManagerFactoryBuilder
                .dataSource(dataSource())
                .properties(hibernateProperties())
                .packages("com.depli.entities.memory")
                .persistenceUnit("memoryDatasourceUnit")
                .build();
    }

    @Bean(name = "memoryDatasourceTransactionManager")
    public PlatformTransactionManager nonPersistentTransactionManager(
            @Qualifier("memoryDatasourceEntityManagerFactory") EntityManagerFactory entityManagerFactory
            ) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    private Map hibernateProperties() {
        Map map = new HashMap<String, String>();

        map.put("hibernate.hbm2ddl.auto", hibernateAutoMode);
        map.put("hibernate.dialect", hibernateDialect);

        return map;
    }

}
