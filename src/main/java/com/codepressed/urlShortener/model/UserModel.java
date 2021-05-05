package com.codepressed.urlShortener.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Codepressed
 */
@Document(collection = "Users")
public class UserModel {
    //TODO User Model
    private String id;
    private String username;
    private String password;
    private String email;
    private Boolean actAccount;
}
