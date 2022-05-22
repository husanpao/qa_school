package cn.ch.qa_school.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.drinkjava2.jsqlbox.DbContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }

    @Bean
    public DbContext mainDbContext() {
        DbContext ctx = new DbContext(getDataSource());
        DbContext.setGlobalDbContext(ctx);
        ctx.setAllowShowSQL(false);
        return ctx;
    }
}
