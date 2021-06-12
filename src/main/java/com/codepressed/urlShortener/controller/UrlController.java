package com.codepressed.urlShortener.controller;

import com.codepressed.urlShortener.service.MongoUtilsServiceImpl;
import com.codepressed.urlShortener.service.ShortUrlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UrlController {
    @Autowired
    MongoUtilsServiceImpl mongoUtilsService;

    @Autowired
    ShortUrlServiceImpl shortUrlService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void redirectToUrl (@PathVariable String id, HttpServletResponse resp) throws Exception{
        final String url = shortUrlService.findUrlById(id);
        resp.addHeader("Location", url);
        resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
    }
}
