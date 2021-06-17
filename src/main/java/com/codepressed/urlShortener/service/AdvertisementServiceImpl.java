package com.codepressed.urlShortener.service;

import com.codepressed.urlShortener.dao.AdvertisementRepository;
import com.codepressed.urlShortener.model.Advertisement;
import com.codepressed.urlShortener.model.ShortUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AdvertisementServiceImpl implements AdvertisementService{

    @Autowired
    AdvertisementRepository advertisementRepository;

    @Autowired
    private MongoUtilsService mongoUtilsService;

    @Override
    public Advertisement save(Advertisement advertisement) {
        advertisement.set_id(mongoUtilsService.getNextValue("AD"));
        return advertisementRepository.insert(advertisement);
    }

    @Override
    public void removeAd(Advertisement advertisement) {
        advertisementRepository.delete(advertisement);
    }

    @Override
    public Advertisement randomAd() {
        List<Advertisement> allAds = advertisementRepository.findAll();
        Random random = new Random();
        return allAds.get(random.nextInt(allAds.size()-1));
    }
}
