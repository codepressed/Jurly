package com.codepressed.urlShortener.dao;

import com.codepressed.urlShortener.model.UrlView;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlViewsDao extends MongoRepository<UrlView, String> {
}
