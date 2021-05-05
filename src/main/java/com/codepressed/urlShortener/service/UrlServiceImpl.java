package com.codepressed.urlShortener.service;

import com.codepressed.urlShortener.model.UrlModel;

import java.util.Date;

/**
 * @author Codepressed
 */

public class UrlServiceImpl implements UrlService{

    @Override
    public UrlModel getUrlFromId(String id) {
        return null;
    }

    @Override
    public long addUrl(String id, String urlName, String urlOwner, String urlDestination, String urlKey, Boolean urlHasAds, Date urlCreationDate) {
        return 0;
    }

    @Override
    public void updateUrl(UrlModel urlModel) {

    }

    @Override
    public void removeUrl(UrlModel urlModel) {
    }

    public static String getUrlFromKey(String urlKey) {
        return null;
    }
}
