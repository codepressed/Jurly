package com.codepressed.urlShortener.service;

import com.codepressed.urlShortener.model.UrlModel;

/**
 * @author Codepressed
 */
public interface UrlService {
    public UrlModel getUrlFromId(String id);
    public long addUrl(String id, String urlName, String urlOwner, String urlDestination, String urlKey, Boolean urlHasAds);
    public void updateUrl(UrlModel urlModel);
    public void removeUrl(UrlModel urlModel);
}
