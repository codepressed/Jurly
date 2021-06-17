package com.codepressed.urlShortener.controller;

import com.codepressed.urlShortener.model.Advertisement;
import com.codepressed.urlShortener.service.AdvertisementService;
import com.codepressed.urlShortener.service.AdvertisementServiceImpl;
import com.codepressed.urlShortener.service.ShortUrlService;
import com.codepressed.urlShortener.service.ShortUrlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ad")
public class AdsController {

    @Autowired
    AdvertisementService advertisementService;

    @Autowired
    ShortUrlService shortUrlService;

    @GetMapping(value="/{id}")
    public String getRandomAd(@PathVariable String id, Model model){
        model.addAttribute("ad", advertisementService.randomAd());
        String url;
        if (shortUrlService.findUrlById(Long.valueOf(id)) != null){
            url = shortUrlService.findUrlById(Long.valueOf(id));
        }else if (shortUrlService.findUrlByCustom(String.valueOf(id)) != null){
            url = shortUrlService.findUrlByCustom(String.valueOf(id));
        }else {
            url = "/error404.html";
        }
        model.addAttribute("url", url);
        return "go";
            }

    @GetMapping("/new_ad")
    public String newAd(Model model) {
        model.addAttribute("advertisement", new Advertisement());
        return "ads";
    }

    @PostMapping("/submit")
    public String submitAd(Advertisement advertisement, Model model){
        advertisementService.save(advertisement);
        return "redirect:new_ad";
    }
}
