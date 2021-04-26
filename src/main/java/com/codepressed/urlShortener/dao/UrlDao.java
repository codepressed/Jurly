package com.codepressed.urlShortener.dao;

import com.codepressed.urlShortener.model.UrlModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Codepressed
 */
@Repository
public interface UrlDao extends MongoRepository<UrlModel, Integer> {
}