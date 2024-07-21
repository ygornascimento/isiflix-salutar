package br.com.isiflix.salutar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-test.properties")
public class DataSourceConfig {

    @Value("${sprint.datasource.url}")
    private String url;

    @Value("${sprint.datasource.username}")
    private String username;

    @Value("${sprint.datasource.password}")
    private String password;

    @Value("${sprint.datasource.driver}")
    private  String driver;

    @Bean
    public DataSource testDataSource() {
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName(driver);
        bds.setUrl(url);
        bds.setUsername(username);
        bds.setPassword(password);
        return bds;
    }
}
