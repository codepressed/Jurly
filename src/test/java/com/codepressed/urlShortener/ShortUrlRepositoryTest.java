package com.codepressed.urlShortener;

import com.codepressed.urlShortener.dao.ShortUrlRepository;
import com.codepressed.urlShortener.model.ShortUrl;
import com.codepressed.urlShortener.service.ShortUrlService;
import com.codepressed.urlShortener.service.ShortUrlServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShortUrlRepositoryTest {

    @Autowired
    ShortUrlRepository shortUrlRepository;

    @Autowired
    ShortUrlService shortUrlService;

    @Test
    public void createUrls(){
        shortUrlRepository.deleteAll();
        Date now = new Date();
        Instant current = now.toInstant();
        shortUrlService.insert(new ShortUrl("https://www.google.com", true, "Dani",
                LocalDateTime.ofInstant(current, ZoneId.systemDefault()), null, 0
                ));
        shortUrlService.insert(new ShortUrl("https://www.google.br", false, "Pedro",
                LocalDateTime.ofInstant(current, ZoneId.systemDefault()), null, 0
        ));
        shortUrlService.insert(new ShortUrl("https://www.google.it", true, "Luka",
                LocalDateTime.ofInstant(current, ZoneId.systemDefault()), null, 0
        ));
        shortUrlService.findAll().forEach(System.out::print);
    }
}
