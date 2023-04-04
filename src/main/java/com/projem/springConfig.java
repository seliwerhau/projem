package com.projem;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import com.projem.services.*;
import com.projem.data.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class springConfig {
    @Bean(name="businessService", initMethod ="init", destroyMethod="destroy")
    @RequestScope
    public businessServiceInterface getBusiness(){
        return new businessService();
    }

    @Bean(name="foodDAO")
    @RequestScope
    public foodDataAccessInterface getDataService(){
        return new foodDataService();
    }

    @Bean 
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:8889/weightsDB");
        dataSource.setUsername( "root" );
        dataSource.setPassword( "root" );
        return dataSource;
    }
}
