package com.codepressed.urlShortener.service;

import com.codepressed.urlShortener.model.Advertisement;

public interface AdvertisementService {
    void save(Advertisement advertisement);
    void removeAd(Advertisement advertisement);
    Advertisement randomAd();



}
