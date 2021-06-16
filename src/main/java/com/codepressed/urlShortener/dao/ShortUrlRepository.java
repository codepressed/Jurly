package com.codepressed.urlShortener.dao;

import com.codepressed.urlShortener.model.ShortUrl;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShortUrlRepository extends MongoRepository<ShortUrl, String> {
    String findByCustomLink(String customLink);
    String findDestinyUrl(String id);
    List<ShortUrl> findLast10Links();
}
