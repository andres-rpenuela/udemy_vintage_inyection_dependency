package com.tokioschool.spring.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class StringConfigurationBean {

	@Bean(name = "stringComponent")
	public String welcomenMSG() {
		return "Hola Mundo 2";
	}
	
	@Bean(name = "stringComponent2")
	@Primary
	public String welcomenMSG2() {
		return "Hola Mundo";
	}
	
}
