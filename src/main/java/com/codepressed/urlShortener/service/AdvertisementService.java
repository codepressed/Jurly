package com.codepressed.urlShortener.service;

import com.codepressed.urlShortener.model.Advertisement;

public interface AdvertisementService {
    Advertisement save(Advertisement advertisement);
    void removeAd(Advertisement advertisement);
    Advertisement randomAd();



}
