package com.codepressed.urlShortener.service;

import com.codepressed.urlShortener.model.Advertisement;

import java.util.List;

public interface AdvertisementService {
    Advertisement save(Advertisement advertisement);
    void removeAd(Long id);
    Advertisement randomAd();
    List<Advertisement> findAll();
}
