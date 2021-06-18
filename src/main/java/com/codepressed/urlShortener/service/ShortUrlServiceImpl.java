package com.codepressed.urlShortener.service;

import com.codepressed.urlShortener.dao.ShortUrlRepository;
import com.codepressed.urlShortener.model.ShortUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return shortUrlRepository.findFirst10ByOrderByCreationDateDesc();
    }

    @Override
    public String findUrlByCustom(String customLink) {
        return shortUrlRepository.findUrlDestinationByUrlCustomized(customLink);
    }

    @Transactional
    @Override
    public void update(String urlId, String urlDestination, Boolean hasAds, String urlCreator, String urlCustomized, Integer urlViews) {
    }

    @Override
    public void delete(Long urlId) {
        shortUrlRepository.deleteById(Long.valueOf(urlId));
    }

    @Override
    public Boolean findHasAdsById(Long shortURLtoID) {
        if (shortUrlRepository.findById(shortURLtoID).isPresent()) {
            return shortUrlRepository.findById(shortURLtoID).get().getHasAds();
        } else
            return false;
    }

    @Override
    public Boolean findHasAdsByCustom(String id) {
        return shortUrlRepository.findHasAdsByUrlCustomized(id);
    }

    @Override
    public String findByUrlCustomized(String urlCustomized){
        return shortUrlRepository.findByUrlCustomized(urlCustomized).get().getUrlDestination();
    }

    @Override
    public Boolean findHasAdsByUrlCustomized(String urlCustomized) {
        return shortUrlRepository.findByUrlCustomized(urlCustomized).get().getHasAds();
    }


}
