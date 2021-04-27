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
    private final String urlName;
    private final String urlOwner;
    private final String urlDestination;
    private final String urlKey; //localhost:8080/go/urlKey
    private final Boolean urlHasAds;

    public UrlModel(String urlName, String urlOwner, String urlDestination, String urlKey, Boolean urlHasAds) {
        this.urlName = urlName;
        this.urlOwner = urlOwner;
        this.urlDestination = urlDestination;
        this.urlKey = urlKey;
        this.urlHasAds = urlHasAds;
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

    public String getUrlDestination() {
        return urlDestination;
    }

    public String getUrlKey() {
        return urlKey;
    }

    public Boolean getUrlHasAds() {
        return urlHasAds;
    }
}
