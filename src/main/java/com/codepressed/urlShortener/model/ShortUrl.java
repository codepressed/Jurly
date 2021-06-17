package com.codepressed.urlShortener.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "urlShorten")
public class ShortUrl {
    @Id
    private Long _id;
    @Field("url_destination")
    private String urlDestination;
    @Field("url_hasAds")
    private Boolean hasAds;
    @Field("url_creator")
    private String urlCreator;
    @CreatedDate
    @Field("url_creationDate")
    private LocalDateTime creationDate;
    @Field("url_customized")
    private String urlCustomized;
    @Field("url_views")
    private Integer urlViews;

    public ShortUrl(String urlDestination, Boolean hasAds, String urlCreator, LocalDateTime creationDate, String urlCustomized, Integer urlViews) {
        this.urlDestination = urlDestination;
        this.hasAds = hasAds;
        this.urlCreator = urlCreator;
        this.creationDate = creationDate;
        this.urlCustomized = urlCustomized;
        this.urlViews = urlViews;
    }

    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        this._id = id;
    }

    public String getUrlDestination() {
        return urlDestination;
    }

    public void setUrlDest(String urlDestination) {
        this.urlDestination = urlDestination;
    }

    public Boolean getHasAds() {
        return hasAds;
    }

    public void setHasAds(Boolean hasAds) {
        this.hasAds = hasAds;
    }

    public String getUrlCustomized() {
        return urlCustomized;
    }

    public String getUrlCreator() {
        return urlCreator;
    }

    public void setUrlCreator(String urlCreator) {
        this.urlCreator = urlCreator;
    }

    public void setUrlCustomized(String urlCustomized) {
        this.urlCustomized = urlCustomized;
    }

    public Integer getUrlViews() {
        return urlViews;
    }

    public void setUrlViews(Integer urlViews) {
        this.urlViews = urlViews;
    }
}
