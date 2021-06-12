package com.codepressed.urlShortener.service;

import com.codepressed.urlShortener.model.ShortUrl;

public interface ShortUrlService {

    ShortUrl insert(ShortUrl shortUrl);

    String findUrlById(String id);
}
