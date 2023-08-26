package com.spring.pos.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {
	
	@Value("${application.name}")
	private String artifactId;
	

    @Bean
    public OpenAPI openAPI() {
        OpenAPI api = new OpenAPI();
        
        Info info = new Info();
        info.setTitle(StringUtils.upperCase(artifactId) + " Document");
        info.setDescription("");
        info.setVersion("v1");
        
		api.info(info);
        return api;
    }

}
