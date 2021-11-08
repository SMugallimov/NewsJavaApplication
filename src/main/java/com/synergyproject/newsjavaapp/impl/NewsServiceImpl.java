package com.synergyproject.newsjavaapp.impl;

import com.synergyproject.newsjavaapp.model.News;
import com.synergyproject.newsjavaapp.repository.NewsRepository;
import com.synergyproject.newsjavaapp.service.NewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        for(News n: newsList){
            if(n.getTitle().equals(newsTitle)){
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