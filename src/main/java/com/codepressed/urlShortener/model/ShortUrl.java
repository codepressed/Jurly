package com.codepressed.urlShortener.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.util.Date;

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
    private Date creationDate;

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
}
