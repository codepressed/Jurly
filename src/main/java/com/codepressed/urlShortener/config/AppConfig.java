package com.codepressed.urlShortener.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Codepressed
 */

@Configuration
@ComponentScan(basePackages = "com.codepressed.urlShortener")
@PropertySource("classpath:/urlshortener.properties")
public class AppConfig {
}
