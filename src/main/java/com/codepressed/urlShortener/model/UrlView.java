package com.codepressed.urlShortener.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Codepressed
 */
@Document(collection = "UrlViews")
public class UrlView {

    @Id
    private String id;
    private final String urlId;
    private final String viewerIp;

    public UrlView(String urlId, String viewerIp) {
        this.urlId = urlId;
        this.viewerIp = viewerIp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlId() {
        return urlId;
    }

    public String getViewerIp() {
        return viewerIp;
    }
}