package com.synergyproject.newsjavaapp.service;

import com.synergyproject.newsjavaapp.model.News;
import com.synergyproject.newsjavaapp.repository.NewsRepository;

import java.util.List;

public class NewsServiceImpl implements NewsService {

    final NewsRepository newsRepository;
    public NewsServiceImpl (NewsRepository newsRepository){
        this.newsRepository = newsRepository;
    }

    @Override
    public void save (News news){
        newsRepository.save(news);
    }

    @Override
    public boolean isExist(String newsTitle) {
        List<News> newsList = newsRepository.findAll();
        for(News news: newsList){
            if(news.getTitle().equals(newsTitle)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }
}