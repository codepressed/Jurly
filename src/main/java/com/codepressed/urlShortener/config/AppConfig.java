package com.codepressed.urlShortener.config;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${app.name}")
    private String appName;

    @Value("${app.description}")
    private String appDescription;

    @Value("${app.copyright}")
    private String appCopyright;

    public String getAppName() {
        return appName;
    }

    public String getAppDescription() {
        return appDescription;
    }

    public String getAppCopyright() {
        return appCopyright;
    }
}
