package com.dev.ck.config.app.profiles;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.zaxxer.hikari.HikariDataSource;

import ckframework.core.annotation.profiles.Local;
import ckframework.persistent.datasource.DataSourceAuthentication;
import ckframework.persistent.datasource.InMemoryDataSourceAuthentication;
import lombok.extern.slf4j.Slf4j;

//@Configuration
@PropertySources(value = {@PropertySource("classpath:/config/app/props/datasource_local.properties")})
@Local
@Slf4j
public class AppConfigLocal {
	@Value("${maria.datasource.classname}") String driver;
	
	public AppConfigLocal() {
		log.info("App local 프로필이 적용 되었습니다. driver:{}", driver);
	}
	
	@Bean
	public String currentStageProfile() {
		return "LOCAL";
	}
	
	@Bean
	public DataSourceAuthentication commonDataSourceAuthentication(
		@Value("${common.jdbc.username}") String user,
		@Value("${common.jdbc.password}") String password
	) {
		log.info("Use InMemoryDataSourceAuthentication user:{}", user);
		InMemoryDataSourceAuthentication auth = new InMemoryDataSourceAuthentication();
		auth.setUser(user);
		auth.setPassword(password);
		return auth;
	}
	
	@Bean(destroyMethod = "close")
	public DataSource commonDataSource(
		@Qualifier("commonDataSourceAuthentication") DataSourceAuthentication auth,
		@Value("${common.jdbc.url}") String url,
		@Value("${common.jdbc.maxPoolSize}") int maxPoolSize,
		@Value("${test.query}") String testQuery
	) {
		log.info("dataSource... url:{}", url);
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName(driver);
		ds.setJdbcUrl(url);
		ds.setUsername(auth.getUser());
		ds.setPassword(auth.getPassword());
		ds.setMaximumPoolSize(maxPoolSize);
		return ds;
	}
	
}
