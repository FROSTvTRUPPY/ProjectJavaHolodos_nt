package com.myProject.repositories;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.JDBCType;

@Configuration
@EnableJdbcRepositories
public class H2DBConfig extends AbstractJdbcConfiguration {


    @Bean
    public DataSource dataSource(){
        JdbcDataSource h2DataSource = new JdbcDataSource();
        h2DataSource.setUser("");
        h2DataSource.setPassword("");
        h2DataSource.setURL("jdbc:h2:./src/data/myBase");
        return h2DataSource;
    }


    @Bean
    @Autowired
    NamedParameterJdbcTemplate  namedParameter(DataSource ds){
        return new NamedParameterJdbcTemplate(ds);
    }

    @Bean
    @Autowired
    PlatformTransactionManager transactionManager(DataSource ds){
        return new JdbcTransactionManager(ds);
    }


}
