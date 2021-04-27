package com.codepressed.urlShortener.controller;

import com.codepressed.urlShortener.config.AppConfig;
import com.codepressed.urlShortener.dao.UrlDao;
import com.codepressed.urlShortener.dao.UserDao;
import com.codepressed.urlShortener.service.UrlServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

/**
 * @author Codepressed
 */

@RestController
public class UrlController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UrlController.class);
    @Autowired
    private AppConfig appConfig;

    private UrlDao urlDao;
    private UserDao userDao;

    public UrlController(UrlDao urlDao) {
        this.urlDao = urlDao;
    }

    @RequestMapping(value = "go/{urlKey}", method=RequestMethod.GET)
    public RedirectView redirectUrl(@PathVariable String urlKey, HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("URL to redirect: " + urlKey);
        String redirectUrlString = UrlServiceImpl.getUrlFromKey(urlKey);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(redirectUrlString);
        return redirectView;
    }


}
