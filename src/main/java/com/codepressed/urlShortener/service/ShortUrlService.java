package com.codepressed.urlShortener.service;

import com.codepressed.urlShortener.model.ShortUrl;

import java.util.List;

public interface ShortUrlService {

    ShortUrl insert(ShortUrl shortUrl);

    String findUrlById(Long id);

    String findUrlByCustom(String customLink);

    List<ShortUrl> findAll();

    List<ShortUrl> findLast10Links();

    void update(String urlId, String urlDestination, Boolean hasAds, String urlCreator, String urlCustomized, Integer urlViews);

    void delete(Long urlId);

    Boolean findHasAdsById(Long shortURLtoID);

    Boolean findHasAdsByCustom(String id);

    String findByUrlCustomized(String urlCustomized);
    Boolean findHasAdsByUrlCustomized(String urlCustomized);
}
