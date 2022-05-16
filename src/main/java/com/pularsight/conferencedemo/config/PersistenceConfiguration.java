package com.pularsight.conferencedemo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration // This is a Spring configuration class which is needed and this can return bean definitions that is stored in the Spring container.
public class PersistenceConfiguration {

    @Bean // This is a Spring bean definition. This is a method that returns a bean. This bean can be used by other beans. This bean is used to create a DataSource bean.
    public DataSource dataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:h2:file:./demo;MODE=PostgreSQL");
        System.out.println("DataSource bean created");

        return builder.build();
    }

}

