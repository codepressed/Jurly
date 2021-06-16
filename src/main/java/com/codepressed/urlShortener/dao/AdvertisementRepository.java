package com.codepressed.urlShortener.dao;

import com.codepressed.urlShortener.model.Advertisement;
import com.codepressed.urlShortener.model.ShortUrl;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface AdvertisementRepository extends MongoRepository<Advertisement, String> {

}
