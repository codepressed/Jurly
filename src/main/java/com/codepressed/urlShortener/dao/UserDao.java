package com.codepressed.urlShortener.dao;

import com.codepressed.urlShortener.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Codepressed
 */
@Repository
public interface UserDao extends MongoRepository<UserModel, Integer> {
}
