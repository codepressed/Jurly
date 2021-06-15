package com.codepressed.urlShortener.service;

import com.codepressed.urlShortener.dao.AdvertisementRepository;
import com.codepressed.urlShortener.model.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

public class AdvertisementServiceImpl implements AdvertisementService{

    @Autowired
    AdvertisementRepository advertisementRepository;

    @Override
    public void addAd(Advertisement advertisement) {
        advertisementRepository.insert(advertisement);
    }

    @Override
    public void removeAd(Advertisement advertisement) {
        advertisementRepository.delete(advertisement);
    }

    @Override
    public Advertisement randomAd() {
        List<Advertisement> allAds = advertisementRepository.findAll();
        Random random = new Random();
        return allAds.get(random.nextInt(allAds.size()-0));
    }
}
