package com.dev.ck.config.webapp;

import java.util.Locale;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.dev.ck.config.app.MybatisConfig;
import com.dev.ck.config.app.profiles.AppConfigLocal;
import com.google.gson.Gson;

import ckframework.core.config.CommonMessageConfigurer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Import({AppConfigLocal.class, MybatisConfig.class})
@ComponentScan(
	basePackages = { 
		"com.dev.ck.churn",
		"com.dev.ck.cltsh"
	}/*,
	excludeFilters = {
		@ComponentScan.Filter(type=FilterType.ANNOTATION, value = Controller.class),
	}*/
)
@MapperScan(
	basePackages = {"com.dev.ck.churn", "com.dev.ck.cltsh"},
	annotationClass = Mapper.class,
	sqlSessionFactoryRef = "commonMybatisSessionFactory",
	sqlSessionTemplateRef = "commonSqlSessionTemplate"
)
public class TestAppConfig implements CommonMessageConfigurer{
	@Override
	public int messageCacheSeconds() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[] messageBasenames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Locale defaultLocale() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Bean
	public Gson gson() {
		return new Gson();
	}
}
