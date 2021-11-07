package com.synergyproject.newsjavaapp.api;

import com.synergyproject.newsjavaapp.model.News;
import com.synergyproject.newsjavaapp.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@Controller
public class NewsController {

    final NewsService newsService;

    public NewsController (NewsService newsService){
        this.newsService = newsService;
    }

    //    @GetMapping(value = "/news")
    public List<News> getAllNews(){
        return newsService.getAllNews();
    }

    @GetMapping(value = "news")
    public String newsMain(Model model){
        model.addAttribute("news", newsService.getAllNews());
        return "news-main";
    }
}