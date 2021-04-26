package com.codepressed.urlShortener.controller;

import com.codepressed.urlShortener.dao.UrlDao;
import com.codepressed.urlShortener.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Codepressed
 */

@RestController
@RequestMapping(path = "")
public class UrlController {

    private UrlDao urlDao;
    private UserDao userDao;

    public UrlController(UrlDao urlDao) {
        this.urlDao = urlDao;
    }




}
