package com.codepressed.urlShortener.config;

import com.codepressed.urlShortener.UrlShortenerApplication;
import com.codepressed.urlShortener.dao.AdvertisementRepository;
import com.codepressed.urlShortener.dao.ShortUrlRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableAutoConfiguration(exclude = { EmbeddedMongoAutoConfiguration.class })
@EnableMongoRepositories(
        basePackageClasses = {
                ShortUrlRepository.class,
                AdvertisementRepository.class
        })
public class MongoConfig {
}
