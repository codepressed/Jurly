package com.codepressed.urlShortener.controller;

import com.codepressed.urlShortener.model.Advertisement;
import com.codepressed.urlShortener.model.ShortUrl;
import com.codepressed.urlShortener.service.AdvertisementService;
import com.codepressed.urlShortener.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class APIController {
    @Autowired
    ShortUrlService shortUrlService;

    @Autowired
    AdvertisementService advertisementService;

    @GetMapping(path = "url/all")
    public List<ShortUrl> getAllUrls(){
        return shortUrlService.findAll();
    }

    @GetMapping(path = "ad/all")
    public List<Advertisement> getAllAds(){
        return advertisementService.findAll();
    }

    @GetMapping(path = "ad/randomAd")
    public Advertisement getRandomAd(){
        return advertisementService.randomAd();
    }

    @PutMapping(path = "url/{urlId}")
    public void updateUrl(@PathVariable("urlId") String urlId,
                          @RequestParam(required = false) String urlDestination,
                          @RequestParam(required = false) Boolean hasAds,
                          @RequestParam(required = false) String urlCreator,
                          @RequestParam(required = false) String urlCustomized,
                          @RequestParam(required = false) Integer urlViews){
        shortUrlService.update(urlId, urlDestination, hasAds, urlCreator, urlCustomized, urlViews);
    }

    @DeleteMapping(path = "url/{urlId}")
    public void deleteUrl(@PathVariable("urlId") Long urlId){
        shortUrlService.delete(urlId);
    }

    @DeleteMapping(path = "ad/{adId}")
    public void deleteAd(@PathVariable("adId") Long adId){
        advertisementService.removeAd(adId);
    }
}
