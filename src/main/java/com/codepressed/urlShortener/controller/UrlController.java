package com.codepressed.urlShortener.controller;

import com.codepressed.urlShortener.model.Advertisement;
import com.codepressed.urlShortener.model.ShortUrl;
import com.codepressed.urlShortener.service.*;
import com.codepressed.urlShortener.util.UrlConversions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UrlController {

    @Autowired
    private ShortUrlService shortUrlService;

    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping(value = "/")
    public String index(@RequestParam(value="newLink", required = false) String newLink, Model model){
        model.addAttribute("links", shortUrlService.findLast10Links());
        model.addAttribute("shortUrl", new ShortUrl());
        model.addAttribute("newLink", newLink);
        return "index";
    }

    @GetMapping(value = "error404.html")
    public String error404(){
        return "error404";
    }

    /**
    public void redirectToUrl (@PathVariable String id, HttpServletResponse resp){
        String url;
        if (shortUrlService.findUrlById(UrlConversions.shortURLtoID(id)) != null){
            url = shortUrlService.findUrlById(UrlConversions.shortURLtoID(id));
        }else if (shortUrlService.findUrlByCustom(String.valueOf(UrlConversions.shortURLtoID(id))) != null){
            url = shortUrlService.findUrlByCustom(String.valueOf(UrlConversions.shortURLtoID(id)));
        }else {
            url = "error404.html";
        }
        resp.addHeader("Location", url);
        resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
    }
    */

    @GetMapping(value="/{id}")
    public void redirectingUrls(@PathVariable String id, HttpServletResponse response){
        String url;
        Boolean hasAds = false;
        if(shortUrlService.findUrlById(UrlConversions.shortURLtoID(id)) != null){
            url = shortUrlService.findUrlById(UrlConversions.shortURLtoID(id));
            hasAds = shortUrlService.findHasAdsById(UrlConversions.shortURLtoID(id));
        }else if(shortUrlService.findUrlByCustom(id) != null){
            url = shortUrlService.findByUrlCustomized(id);
            hasAds = shortUrlService.findHasAdsByUrlCustomized(id);
        }else{
            url = "error404.html";
        }

        if(hasAds){
            url = "go/" + id;
        }
        response.addHeader("Location", url);
        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
    }

    @GetMapping(value = "/go/{id}")
    public String randomAd(@PathVariable("id") String id, Model model) {
        Advertisement ad = advertisementService.randomAd();
        if (ad != null) {
            model.addAttribute("advertisement", ad);
            if(shortUrlService.findUrlById(UrlConversions.shortURLtoID(id)) == null){
                model.addAttribute("url", shortUrlService.findByUrlCustomized(id));
            }
            else{
                model.addAttribute("url", shortUrlService.findUrlById(UrlConversions.shortURLtoID(id)));
            }
            return "go";
        }
        return "error404.html";

    }

    @PostMapping("/addurl")
    public String submitNewUrl(ShortUrl shortUrl, RedirectAttributes redirectAttributes, Model model) {
        shortUrlService.insert(shortUrl);
        model.addAttribute("links", shortUrlService.findLast10Links());
        redirectAttributes.addAttribute("newLink", UrlConversions.idToShortURL(Math.toIntExact(shortUrl.getId())));
        return "redirect:/";

    }


}

