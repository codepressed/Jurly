package com.codepressed.urlShortener.service;

import com.codepressed.urlShortener.model.ShortUrl;

import java.util.List;

public interface ShortUrlService {

    ShortUrl insert(ShortUrl shortUrl);

    String findUrlById(Long id);

    String findUrlByCustom(String customLink);

    List<ShortUrl> findAll();

    List<ShortUrl> findLast10Links();

    String findDestinyUrl(String id);
}
