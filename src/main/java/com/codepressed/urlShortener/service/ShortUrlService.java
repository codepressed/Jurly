package com.codepressed.urlShortener.service;

import com.codepressed.urlShortener.model.ShortUrl;

import java.util.List;

public interface ShortUrlService {

    ShortUrl insert(ShortUrl shortUrl);

    String findUrlById(String id);

    String findUrlByCustom(String customLink);

    List<ShortUrl> findAll();

    List<ShortUrl> findLast10Links();



}
