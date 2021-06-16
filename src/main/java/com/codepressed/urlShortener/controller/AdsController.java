package com.codepressed.urlShortener.controller;

import com.codepressed.urlShortener.model.Advertisement;
import com.codepressed.urlShortener.service.AdvertisementServiceImpl;
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
    AdvertisementServiceImpl advertisementServiceImpl;

    @Autowired
    ShortUrlServiceImpl shortUrlServiceImpl;

    @GetMapping(value="/{id}")
    public String getRandomAd(@PathVariable String id, Model model){
        model.addAttribute("ad", advertisementServiceImpl.randomAd());
        String url;
        if (shortUrlServiceImpl.findUrlById(id) != null){
            url = shortUrlServiceImpl.findUrlById(id);
        }else if (shortUrlServiceImpl.findUrlByCustom(id) != null){
            url = shortUrlServiceImpl.findUrlByCustom(id);
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
        advertisementServiceImpl.save(advertisement);
        return "redirect:ad/new_ad";
    }
}
