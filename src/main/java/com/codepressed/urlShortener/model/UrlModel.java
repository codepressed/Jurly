package com.codepressed.urlShortener.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Codepressed
 */
@Document(collection = "ShortenedUrls")
public class UrlModel {

    @Id
    private String id;
    private String urlName;
    private String urlOwner;
    private String urlDestinity;
    private String urlKey;

    public UrlModel(String urlName, String urlOwner, String urlDestinity, String urlKey) {
        this.urlName = urlName;
        this.urlOwner = urlOwner;
        this.urlDestinity = urlDestinity;
        this.urlKey = urlKey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlName() {
        return urlName;
    }

    public String getUrlOwner() {
        return urlOwner;
    }

    public String getUrlDestinity() {
        return urlDestinity;
    }

    public String getUrlKey() {
        return urlKey;
    }
}
