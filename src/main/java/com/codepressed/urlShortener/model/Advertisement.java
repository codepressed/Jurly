package com.codepressed.urlShortener.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ads")
public class Advertisement {
    @Id
    private Long _id;
    @Field("ad_name")
    private String adName;
    @Field("ad_description")
    private String adDescription;
    @Field("ad_image")
    private String adImageLink;
    @Field("ad_destination")
    private String adDestination;


    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdDescription() {
        return adDescription;
    }

    public void setAdDescription(String adDescription) {
        this.adDescription = adDescription;
    }

    public String getAdImageLink() {
        return adImageLink;
    }

    public void setAdImageLink(String adImageLink) {
        this.adImageLink = adImageLink;
    }

    public String getAdDestination() {
        return adDestination;
    }

    public void setAdDestination(String adDestination) {
        this.adDestination = adDestination;
    }
}
