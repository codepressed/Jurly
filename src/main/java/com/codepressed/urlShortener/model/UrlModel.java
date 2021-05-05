package com.codepressed.urlShortener.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

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
    private final Date urlCreationDate;

    public UrlModel(String urlName, String urlOwner, String urlDestination, String urlKey, Boolean urlHasAds, Date urlCreationDate) {
        this.urlName = urlName;
        this.urlOwner = urlOwner;
        this.urlDestination = urlDestination;
        this.urlKey = urlKey;
        this.urlHasAds = urlHasAds;
        this.urlCreationDate = urlCreationDate;
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

    public Date getUrlCreationDate() {
        return urlCreationDate;
    }
}
