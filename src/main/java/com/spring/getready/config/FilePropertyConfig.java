package com.spring.getready.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
public class FilePropertyConfig {

	@Value("${file.upload-path}")
	private String filePath;
	
	@Value("${user.default-password}")
	private String defaultPassword;

	public String getFilePath() {
		return filePath;
	}
	
	public String getDefaultPassword() {
		return defaultPassword;
	}

}
