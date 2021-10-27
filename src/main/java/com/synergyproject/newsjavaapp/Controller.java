package com.synergyproject.newsjavaapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    NewsService newsService;

    @GetMapping(value = "news")
    public List<News> getAllNews(){
        return newsService.getTopNews();
    }
}