package com.codepressed.urlShortener.service;

import com.codepressed.urlShortener.dao.ShortUrlRepository;
import com.codepressed.urlShortener.model.ShortUrl;
import org.springframework.beans.factory.annotation.Autowired;

public class ShortUrlServiceImpl implements ShortUrlService{
    @Autowired
    private ShortUrlRepository shortUrlRepository;

    @Autowired
    private MongoUtilsServiceImpl mongoUtilsService;

    @Override
    public ShortUrl insert(ShortUrl newUrl) {
        newUrl.setId(mongoUtilsService.getNextValue("URL"));
        return shortUrlRepository.insert(newUrl);
    }

    @Override
    public String findUrlById(String id) {
        if (shortUrlRepository.findById(id).isPresent()){
            return shortUrlRepository.findById(id).get().getUrlDestination();
        } else{
            return "/";
        }
    }


}
