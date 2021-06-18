package com.codepressed.urlShortener.dao;

import com.codepressed.urlShortener.model.ShortUrl;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface ShortUrlRepository extends MongoRepository<ShortUrl,Long> {

    /**
     * Find final url destination by Customized Link
     * @param customLink
     * @return
     */
    String findUrlDestinationByUrlCustomized(String customLink);

    /**
     * Find last 10 created or modified URLs
     * @return
     */
    List<ShortUrl> findFirst10ByOrderByCreationDateDesc();


    Boolean findHasAdsByUrlCustomized(String id);

    Optional<ShortUrl> findByUrlCustomized(String customLink);
}
