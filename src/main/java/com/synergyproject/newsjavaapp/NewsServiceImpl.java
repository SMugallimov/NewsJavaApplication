package com.synergyproject.newsjavaapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{

    @Autowired
    NewsRepository newsRepository;

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
    public List<News> getTopNews() {
        return newsRepository.findAll();
    }
}