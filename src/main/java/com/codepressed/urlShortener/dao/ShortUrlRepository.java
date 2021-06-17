package com.codepressed.urlShortener.dao;

import com.codepressed.urlShortener.model.ShortUrl;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ShortUrlRepository extends MongoRepository<ShortUrl,Long> {

    String findUrlDestinationByUrlCustomized(String customLink);

    String findUrlDestinationById(Long id);

    List<ShortUrl> findFirst10ByCreationDateDesc();
}
