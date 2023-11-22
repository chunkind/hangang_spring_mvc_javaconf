package com.dev.ck.config.webapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.dev.ck.config.app.profiles.AppConfigCommon;
import com.dev.ck.config.app.profiles.AppConfigLocal;
import com.dev.ck.config.app.profiles.AppConfigProduction;

//@Configuration
@Import({
	AppConfigCommon.class,
	AppConfigLocal.class, AppConfigProduction.class
})
public class WebApplicationConfig {

	
}
