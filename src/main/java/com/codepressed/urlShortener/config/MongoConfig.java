package com.codepressed.urlShortener.config;

import com.codepressed.urlShortener.UrlShortenerApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableAutoConfiguration(exclude = { EmbeddedMongoAutoConfiguration.class })
@EnableMongoRepositories(
        basePackageClasses = {
                UrlShortenerApplication.class
        })
@ComponentScan(
        basePackageClasses = {
                UrlShortenerApplication.class
        })
public class MongoConfig {
}
