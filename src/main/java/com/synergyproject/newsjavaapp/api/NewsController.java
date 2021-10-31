package com.synergyproject.newsjavaapp.api;

import com.synergyproject.newsjavaapp.model.News;
import com.synergyproject.newsjavaapp.repository.NewsRepository;
import com.synergyproject.newsjavaapp.service.NewsService;
import com.synergyproject.newsjavaapp.service.NewsServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {

    final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping(value = "news")
    public List<News> getAllNews(){
        return newsService.getAllNews();
    }

}