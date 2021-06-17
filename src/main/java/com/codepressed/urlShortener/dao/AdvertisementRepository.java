package com.codepressed.urlShortener.dao;

import com.codepressed.urlShortener.model.Advertisement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AdvertisementRepository extends MongoRepository<Advertisement,Long> {

}
