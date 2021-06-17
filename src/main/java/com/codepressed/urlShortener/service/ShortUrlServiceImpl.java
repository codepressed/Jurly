package com.codepressed.urlShortener.service;

import com.codepressed.urlShortener.dao.ShortUrlRepository;
import com.codepressed.urlShortener.model.ShortUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortUrlServiceImpl implements ShortUrlService{

    @Autowired
    private ShortUrlRepository shortUrlRepository;

    @Autowired
    private MongoUtilsService mongoUtilsService;


    @Override
    public ShortUrl insert(ShortUrl newUrl) {
        newUrl.setId(mongoUtilsService.getNextValue("URL"));
        return shortUrlRepository.insert(newUrl);
    }

    @Override
    public String findUrlById(Long id) {
        if (shortUrlRepository.findById(id).isPresent()){
            return shortUrlRepository.findById(id).get().getUrlDestination();
        } else{
            return null;
        }
    }

    @Override
    public List<ShortUrl> findAll() {
        return shortUrlRepository.findAll();
    }

    @Override
    public List<ShortUrl> findLast10Links() {
        return shortUrlRepository.findFirst10ByCreationDateDesc();
    }

    @Override
    public String findDestinyUrl(String id) {
        return shortUrlRepository.findUrlDestinationById(Long.valueOf(id));
    }

    @Override
    public String findUrlByCustom(String customLink) {
        return shortUrlRepository.findUrlDestinationByUrlCustomized(customLink);
    }
}
